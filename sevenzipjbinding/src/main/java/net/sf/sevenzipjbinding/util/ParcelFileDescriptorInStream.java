package net.sf.sevenzipjbinding.util;

import android.os.ParcelFileDescriptor;

import net.sf.sevenzipjbinding.IInStream;
import net.sf.sevenzipjbinding.SevenZipException;

import java.io.Closeable;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * An {@link IInStream} implementation backed by an Android {@link ParcelFileDescriptor}.
 * Useful for reading archives from Scoped Storage / Content URIs on Android.
 */
public class ParcelFileDescriptorInStream implements IInStream, Closeable {
    private final ParcelFileDescriptor pfd;
    private final FileInputStream fis;
    private final FileChannel channel;

    public ParcelFileDescriptorInStream(ParcelFileDescriptor pfd) {
        if (pfd == null) {
            throw new IllegalArgumentException("ParcelFileDescriptor must not be null");
        }
        this.pfd = pfd;
        this.fis = new FileInputStream(pfd.getFileDescriptor());
        this.channel = fis.getChannel();
    }

    @Override
    public synchronized long seek(long offset, int seekOrigin) throws SevenZipException {
        try {
            switch (seekOrigin) {
                case SEEK_SET:
                    channel.position(offset);
                    break;
                case SEEK_CUR:
                    channel.position(channel.position() + offset);
                    break;
                case SEEK_END:
                    channel.position(channel.size() + offset);
                    break;
                default:
                    throw new SevenZipException("Unsupported seek origin: " + seekOrigin);
            }
            return channel.position();
        } catch (IOException e) {
            throw new SevenZipException(e);
        }
    }

    @Override
    public synchronized int read(byte[] data) throws SevenZipException {
        try {
            ByteBuffer buffer = ByteBuffer.wrap(data);
            int bytesRead = channel.read(buffer);
            return Math.max(bytesRead, 0);
        } catch (IOException e) {
            throw new SevenZipException(e);
        }
    }

    @Override
    public synchronized void close() throws IOException {
        try {
            channel.close();
        } finally {
            try {
                fis.close();
            } finally {
                pfd.close();
            }
        }
    }
}
