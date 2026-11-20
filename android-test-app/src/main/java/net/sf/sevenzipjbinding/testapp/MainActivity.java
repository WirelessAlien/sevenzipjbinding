package net.sf.sevenzipjbinding.testapp;

import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import net.sf.sevenzipjbinding.ArchiveFormat;
import net.sf.sevenzipjbinding.ExtractAskMode;
import net.sf.sevenzipjbinding.ExtractOperationResult;
import net.sf.sevenzipjbinding.IArchiveExtractCallback;
import net.sf.sevenzipjbinding.IInArchive;
import net.sf.sevenzipjbinding.ISequentialOutStream;
import net.sf.sevenzipjbinding.PropID;
import net.sf.sevenzipjbinding.SevenZip;
import net.sf.sevenzipjbinding.SevenZipException;
import net.sf.sevenzipjbinding.util.ParcelFileDescriptorInStream;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "7ZipJBindingTest";
    private TextView logTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        logTextView = new TextView(this);
        logTextView.setPadding(32, 32, 32, 32);
        setContentView(logTextView);

        runTests();
    }

    public void runTests() {
        StringBuilder sb = new StringBuilder();
        sb.append("Starting 7-Zip-JBinding Android Tests...\n\n");

        try {
            SevenZip.initSevenZipFromPlatformJAR();

            boolean initialized = SevenZip.isInitializedSuccessfully();
            sb.append("0. isAndroid: ").append(SevenZip.isAndroid()).append("\n");
            sb.append("1. Native Library Initialized: ").append(initialized).append("\n");
            Log.i(TAG, "Native Library Initialized: " + initialized);

            SevenZip.Version version = SevenZip.getSevenZipVersion();
            sb.append("2. 7-Zip Version: ")
              .append(version.major).append(".").append(version.minor)
              .append(" (").append(version.version).append(")\n");
            sb.append("3. 7-Zip-JBinding Version: ")
              .append(SevenZip.getSevenZipJBindingVersion()).append("\n");

            Log.i(TAG, "7-Zip Version: " + version.version);
            Log.i(TAG, "7-Zip-JBinding Version: " + SevenZip.getSevenZipJBindingVersion());

            testArchiveOperations(sb);

            sb.append("\nALL TESTS PASSED SUCCESSFULLY!");
        } catch (Throwable t) {
            sb.append("\nTEST ERROR: ").append(t.getMessage()).append("\n");
            Log.e(TAG, "Test error", t);
        }

        logTextView.setText(sb.toString());
    }

    private void testArchiveOperations(StringBuilder sb) throws Exception {
        sb.append("\n--- Running Archive Test ---\n");

        File tempFile = File.createTempFile("test_archive", ".zip", getCacheDir());
        try (java.util.zip.ZipOutputStream zos = new java.util.zip.ZipOutputStream(new FileOutputStream(tempFile))) {
            zos.putNextEntry(new java.util.zip.ZipEntry("hello.txt"));
            byte[] data = "Hello, 7-Zip-JBinding on Android!".getBytes("UTF-8");
            zos.write(data, 0, data.length);
            zos.closeEntry();
        }

        sb.append("Created temporary test zip archive: ").append(tempFile.getName()).append("\n");

        try (ParcelFileDescriptor pfd = ParcelFileDescriptor.open(tempFile, ParcelFileDescriptor.MODE_READ_ONLY);
             ParcelFileDescriptorInStream inStream = new ParcelFileDescriptorInStream(pfd);
             IInArchive inArchive = SevenZip.openInArchive(ArchiveFormat.ZIP, inStream)) {

            sb.append("Opened archive format: ").append(inArchive.getArchiveFormat().getMethodName()).append("\n");
            int numberOfItems = inArchive.getNumberOfItems();
            sb.append("Number of items in archive: ").append(numberOfItems).append("\n");

            for (int i = 0; i < numberOfItems; i++) {
                String path = inArchive.getStringProperty(i, PropID.PATH);
                Long size = (Long) inArchive.getProperty(i, PropID.SIZE);
                sb.append("  Item ").append(i).append(": ").append(path).append(" (size: ").append(size).append(" bytes)\n");
            }

            final ByteArrayOutputStream extractedData = new ByteArrayOutputStream();
            inArchive.extract(null, false, new IArchiveExtractCallback() {
                @Override
                public ISequentialOutStream getStream(int index, ExtractAskMode extractAskMode) throws SevenZipException {
                    return new ISequentialOutStream() {
                        @Override
                        public int write(byte[] data) throws SevenZipException {
                            extractedData.write(data, 0, data.length);
                            return data.length;
                        }
                    };
                }

                @Override
                public void prepareOperation(ExtractAskMode extractAskMode) throws SevenZipException {}

                @Override
                public void setOperationResult(ExtractOperationResult extractOperationResult) throws SevenZipException {
                    Log.i(TAG, "Extract operation result: " + extractOperationResult);
                }

                @Override
                public void setTotal(long total) throws SevenZipException {}

                @Override
                public void setCompleted(long complete) throws SevenZipException {}
            });

            String extractedContent = extractedData.toString("UTF-8");
            sb.append("Extracted content: '").append(extractedContent).append("'\n");

            if ("Hello, 7-Zip-JBinding on Android!".equals(extractedContent)) {
                sb.append("Content verification: MATCHED SUCCESSFULLY!\n");
            } else {
                throw new RuntimeException("Extracted content mismatch: " + extractedContent);
            }
        } finally {
            tempFile.delete();
        }
    }
}
