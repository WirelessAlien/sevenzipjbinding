cmake_minimum_required(VERSION 3.22.1)
project("7-Zip-JBinding")

set(ROOT_DIR "${CMAKE_CURRENT_SOURCE_DIR}/../../../..")
set(SEVEN_ZIP_SRC "${ROOT_DIR}/7zip")
set(JBINDING_CPP_DIR "${ROOT_DIR}/jbinding-cpp")

set(CMAKE_CXX_STANDARD 17)
set(CMAKE_CXX_STANDARD_REQUIRED ON)

add_definitions(
    -D_FILE_OFFSET_BITS=64
    -D_LARGEFILE_SOURCE
    -D_LARGEFILE64_SOURCE
    -D_REENTRANT
    -DENV_UNIX
    -D_7ZIP_LARGE_PAGES
    -DENV_HAVE_GCCVISIBILITYPATCH
    -DBREAK_HANDLER
    -DUNICODE
    -D_UNICODE
    -DUNIX_USE_WIN_FILE
    -DNDEBUG
    -DZ7_JB_DISABLE_VAES
    -DZ7_JB_NO_SECURITY_CODE
    -fPIC
    -fexceptions
    -fvisibility=hidden
)

set(CMAKE_C_FLAGS "${CMAKE_C_FLAGS} -ffunction-sections -fdata-sections")
set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -ffunction-sections -fdata-sections")

include_directories(
    ${CMAKE_CURRENT_SOURCE_DIR}/javah
    ${JBINDING_CPP_DIR}
    ${SEVEN_ZIP_SRC}
    ${SEVEN_ZIP_SRC}/CPP
    ${SEVEN_ZIP_SRC}/C
    ${SEVEN_ZIP_SRC}/CPP/Windows
)

set(SEVEN_ZIP_SOURCE_FILES
    ${SEVEN_ZIP_SRC}/CPP/Common/CommandLineParser.cpp
    ${SEVEN_ZIP_SRC}/CPP/Common/CRC.cpp
    ${SEVEN_ZIP_SRC}/CPP/Common/XzCrc64Init.cpp
    ${SEVEN_ZIP_SRC}/CPP/Common/IntToString.cpp
    ${SEVEN_ZIP_SRC}/CPP/Common/ListFileUtils.cpp
    ${SEVEN_ZIP_SRC}/CPP/Common/MyString.cpp
    ${SEVEN_ZIP_SRC}/CPP/Common/MyWindows.cpp
    ${SEVEN_ZIP_SRC}/CPP/Common/StringConvert.cpp
    ${SEVEN_ZIP_SRC}/CPP/Common/StringToInt.cpp
    ${SEVEN_ZIP_SRC}/CPP/Common/UTFConvert.cpp
    ${SEVEN_ZIP_SRC}/CPP/Common/MyVector.cpp
    ${SEVEN_ZIP_SRC}/CPP/Common/MyMap.cpp
    ${SEVEN_ZIP_SRC}/CPP/Common/MyXml.cpp
    ${SEVEN_ZIP_SRC}/CPP/Common/Wildcard.cpp
    ${SEVEN_ZIP_SRC}/CPP/Common/DynLimBuf.cpp

    ${SEVEN_ZIP_SRC}/CPP/Windows/FileDir.cpp
    ${SEVEN_ZIP_SRC}/CPP/Windows/FileFind.cpp
    ${SEVEN_ZIP_SRC}/CPP/Windows/FileIO.cpp
    ${SEVEN_ZIP_SRC}/CPP/Windows/FileLink.cpp
    ${SEVEN_ZIP_SRC}/CPP/Windows/FileName.cpp
    ${SEVEN_ZIP_SRC}/CPP/Windows/PropVariant.cpp
    ${SEVEN_ZIP_SRC}/CPP/Windows/PropVariantConv.cpp
    ${SEVEN_ZIP_SRC}/CPP/Windows/PropVariantUtils.cpp
    ${SEVEN_ZIP_SRC}/CPP/Windows/Synchronization.cpp
    ${SEVEN_ZIP_SRC}/CPP/Windows/System.cpp
    ${SEVEN_ZIP_SRC}/CPP/Windows/TimeUtils.cpp

    ${SEVEN_ZIP_SRC}/CPP/7zip/Common/CreateCoder.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Common/CWrappers.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Common/FilePathAutoRename.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Common/FileStreams.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Common/FilterCoder.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Common/InBuffer.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Common/InOutTempBuffer.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Common/LimitedStreams.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Common/MemBlocks.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Common/MethodId.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Common/MethodProps.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Common/OffsetStream.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Common/OutBuffer.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Common/OutMemStream.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Common/ProgressMt.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Common/ProgressUtils.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Common/PropId.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Common/StreamBinder.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Common/StreamObjects.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Common/StreamUtils.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Common/UniqBlocks.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Common/VirtThread.cpp

    ${SEVEN_ZIP_SRC}/CPP/7zip/UI/Common/LoadCodecs.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/UI/Common/PropIDUtils.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/UI/Common/HashCalc.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/UI/Common/EnumDirItems.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/UI/Common/SortUtils.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/UI/Console/ConsoleClose.cpp

    ${SEVEN_ZIP_SRC}/CPP/7zip/Archive/ZHandler.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Archive/Bz2Handler.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Archive/DeflateProps.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Archive/GzHandler.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Archive/FatHandler.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Archive/HandlerCont.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Archive/ExtHandler.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Archive/HfsHandler.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Archive/LzmaHandler.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Archive/NtfsHandler.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Archive/PpmdHandler.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Archive/SplitHandler.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Archive/XzHandler.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Archive/LzhHandler.cpp

    ${SEVEN_ZIP_SRC}/CPP/7zip/Archive/Common/CoderMixer2.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Archive/Common/DummyOutStream.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Archive/Common/FindSignature.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Archive/Common/HandlerOut.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Archive/Common/InStreamWithCRC.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Archive/Common/ItemNameUtils.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Archive/Common/MultiStream.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Archive/Common/OutStreamWithCRC.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Archive/Common/OutStreamWithSha1.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Archive/Common/ParseProperties.cpp

    ${SEVEN_ZIP_SRC}/CPP/7zip/Archive/7z/7zCompressionMode.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Archive/7z/7zDecode.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Archive/7z/7zEncode.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Archive/7z/7zExtract.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Archive/7z/7zFolderInStream.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Archive/7z/7zHandler.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Archive/7z/7zHandlerOut.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Archive/7z/7zHeader.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Archive/7z/7zIn.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Archive/7z/7zOut.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Archive/7z/7zProperties.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Archive/7z/7zSpecStream.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Archive/7z/7zUpdate.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Archive/7z/7zRegister.cpp

    ${SEVEN_ZIP_SRC}/CPP/7zip/Archive/Cab/CabBlockInStream.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Archive/Cab/CabHandler.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Archive/Cab/CabHeader.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Archive/Cab/CabIn.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Archive/Cab/CabRegister.cpp

    ${SEVEN_ZIP_SRC}/CPP/7zip/Compress/LzhDecoder.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Compress/LzmsDecoder.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Compress/LzfseDecoder.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Compress/ZstdDecoder.cpp

    ${SEVEN_ZIP_SRC}/CPP/7zip/Archive/Chm/ChmHandler.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Archive/Chm/ChmIn.cpp

    ${SEVEN_ZIP_SRC}/CPP/7zip/Archive/Udf/UdfHandler.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Archive/Udf/UdfIn.cpp

    ${SEVEN_ZIP_SRC}/CPP/7zip/Archive/Wim/WimHandler.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Archive/Wim/WimHandlerOut.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Archive/Wim/WimIn.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Archive/Wim/WimRegister.cpp

    ${SEVEN_ZIP_SRC}/CPP/7zip/Archive/ArHandler.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Archive/RpmHandler.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Archive/XarHandler.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Archive/ArjHandler.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Archive/CpioHandler.cpp

    ${SEVEN_ZIP_SRC}/CPP/7zip/Archive/Iso/IsoHandler.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Archive/Iso/IsoHeader.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Archive/Iso/IsoIn.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Archive/Iso/IsoRegister.cpp

    ${SEVEN_ZIP_SRC}/CPP/7zip/Archive/Nsis/NsisDecode.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Archive/Nsis/NsisHandler.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Archive/Nsis/NsisIn.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Archive/Nsis/NsisRegister.cpp

    ${SEVEN_ZIP_SRC}/CPP/7zip/Archive/Rar/RarHandler.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Archive/Rar/Rar5Handler.cpp

    ${SEVEN_ZIP_SRC}/CPP/7zip/Archive/Tar/TarHandler.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Archive/Tar/TarHandlerOut.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Archive/Tar/TarHeader.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Archive/Tar/TarIn.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Archive/Tar/TarOut.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Archive/Tar/TarRegister.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Archive/Tar/TarUpdate.cpp

    ${SEVEN_ZIP_SRC}/CPP/7zip/Archive/Zip/ZipAddCommon.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Archive/Zip/ZipHandler.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Archive/Zip/ZipHandlerOut.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Archive/Zip/ZipIn.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Archive/Zip/ZipItem.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Archive/Zip/ZipOut.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Archive/Zip/ZipUpdate.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Archive/Zip/ZipRegister.cpp

    ${SEVEN_ZIP_SRC}/CPP/7zip/Compress/Bcj2Coder.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Compress/Bcj2Register.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Compress/BcjCoder.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Compress/BcjRegister.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Compress/BitlDecoder.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Compress/BranchMisc.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Compress/BranchRegister.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Compress/ByteSwap.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Compress/BZip2Crc.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Compress/BZip2Decoder.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Compress/BZip2Encoder.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Compress/BZip2Register.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Compress/CopyCoder.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Compress/CopyRegister.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Compress/Deflate64Register.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Compress/DeflateDecoder.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Compress/DeflateEncoder.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Compress/DeflateRegister.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Compress/DeltaFilter.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Compress/Lzma2Decoder.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Compress/Lzma2Encoder.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Compress/Lzma2Register.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Compress/ImplodeDecoder.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Compress/ImplodeHuffmanDecoder.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Compress/LzmaDecoder.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Compress/LzmaEncoder.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Compress/LzmaRegister.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Compress/LzOutWindow.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Compress/LzxDecoder.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Compress/PpmdDecoder.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Compress/PpmdEncoder.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Compress/PpmdRegister.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Compress/PpmdZip.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Compress/QuantumDecoder.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Compress/Rar1Decoder.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Compress/Rar2Decoder.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Compress/Rar3Decoder.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Compress/Rar3Vm.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Compress/Rar5Decoder.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Compress/RarCodecsRegister.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Compress/ShrinkDecoder.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Compress/ZDecoder.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Compress/XpressDecoder.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Compress/XzEncoder.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Compress/XzDecoder.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Compress/ZlibDecoder.cpp

    ${SEVEN_ZIP_SRC}/CPP/7zip/Crypto/7zAes.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Crypto/7zAesRegister.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Crypto/HmacSha1.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Crypto/HmacSha256.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Crypto/MyAes.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Crypto/Pbkdf2HmacSha1.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Crypto/RandGen.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Crypto/Rar20Crypto.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Crypto/Rar5Aes.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Crypto/RarAes.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Crypto/WzAes.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Crypto/ZipCrypto.cpp
    ${SEVEN_ZIP_SRC}/CPP/7zip/Crypto/ZipStrong.cpp

    ${SEVEN_ZIP_SRC}/C/Bcj2.c
    ${SEVEN_ZIP_SRC}/C/Bcj2Enc.c
    ${SEVEN_ZIP_SRC}/C/Blake2s.c
    ${SEVEN_ZIP_SRC}/C/Bra.c
    ${SEVEN_ZIP_SRC}/C/Bra86.c
    ${SEVEN_ZIP_SRC}/C/BraIA64.c
    ${SEVEN_ZIP_SRC}/C/BwtSort.c
    ${SEVEN_ZIP_SRC}/C/CpuArch.c
    ${SEVEN_ZIP_SRC}/C/HuffEnc.c
    ${SEVEN_ZIP_SRC}/C/LzFind.c
    ${SEVEN_ZIP_SRC}/C/LzFindMt.c
    ${SEVEN_ZIP_SRC}/C/LzmaDec.c
    ${SEVEN_ZIP_SRC}/C/LzmaEnc.c
    ${SEVEN_ZIP_SRC}/C/Sort.c
    ${SEVEN_ZIP_SRC}/C/Sha1.c
    ${SEVEN_ZIP_SRC}/C/Threads.c
    ${SEVEN_ZIP_SRC}/C/Aes.c
    ${SEVEN_ZIP_SRC}/C/Alloc.c
    ${SEVEN_ZIP_SRC}/C/Sha256.c
    ${SEVEN_ZIP_SRC}/C/7zCrc.c
    ${SEVEN_ZIP_SRC}/C/7zCrcOpt.c
    ${SEVEN_ZIP_SRC}/C/SwapBytes.c
    ${SEVEN_ZIP_SRC}/C/Lzma2DecMt.c
    ${SEVEN_ZIP_SRC}/C/AesOpt.c
    ${SEVEN_ZIP_SRC}/C/LzFindOpt.c
    ${SEVEN_ZIP_SRC}/C/Sha1Opt.c
    ${SEVEN_ZIP_SRC}/C/Sha256Opt.c
    ${SEVEN_ZIP_SRC}/C/MtDec.c
    ${SEVEN_ZIP_SRC}/C/7zStream.c
    ${SEVEN_ZIP_SRC}/C/Delta.c
    ${SEVEN_ZIP_SRC}/C/Lzma2Dec.c
    ${SEVEN_ZIP_SRC}/C/Lzma2Enc.c
    ${SEVEN_ZIP_SRC}/C/MtCoder.c
    ${SEVEN_ZIP_SRC}/C/Ppmd7.c
    ${SEVEN_ZIP_SRC}/C/Ppmd7Dec.c
    ${SEVEN_ZIP_SRC}/C/Ppmd7aDec.c
    ${SEVEN_ZIP_SRC}/C/Ppmd7Enc.c
    ${SEVEN_ZIP_SRC}/C/Ppmd8.c
    ${SEVEN_ZIP_SRC}/C/Ppmd8Dec.c
    ${SEVEN_ZIP_SRC}/C/Ppmd8Enc.c
    ${SEVEN_ZIP_SRC}/C/Xz.c
    ${SEVEN_ZIP_SRC}/C/XzCrc64.c
    ${SEVEN_ZIP_SRC}/C/XzCrc64Opt.c
    ${SEVEN_ZIP_SRC}/C/XzDec.c
    ${SEVEN_ZIP_SRC}/C/XzEnc.c
    ${SEVEN_ZIP_SRC}/C/XzIn.c
    ${SEVEN_ZIP_SRC}/C/Sha512.c
    ${SEVEN_ZIP_SRC}/C/Sha512Opt.c
    ${SEVEN_ZIP_SRC}/C/Xxh64.c
    ${SEVEN_ZIP_SRC}/C/ZstdDec.c
)

set(JBINDING_CPP_FILES
    ${JBINDING_CPP_DIR}/Debug.cpp
    ${JBINDING_CPP_DIR}/JNITools.cpp
    ${JBINDING_CPP_DIR}/JavaStaticInfo.cpp
    ${JBINDING_CPP_DIR}/SevenZipJBinding.cpp
    ${JBINDING_CPP_DIR}/UniversalArchiveOpenCallback.cpp
    ${JBINDING_CPP_DIR}/UserTrace.cpp
    ${JBINDING_CPP_DIR}/CodecTools.cpp
    ${JBINDING_CPP_DIR}/JBindingTools.cpp
    ${JBINDING_CPP_DIR}/CHeadCacheInStream.cpp
    ${JBINDING_CPP_DIR}/JavaToCPP/JavaToCPPSevenZip.cpp
    ${JBINDING_CPP_DIR}/JavaToCPP/JavaToCPPInArchiveImpl.cpp
    ${JBINDING_CPP_DIR}/JavaToCPP/JavaToCPPOutArchiveImpl.cpp
    ${JBINDING_CPP_DIR}/CPPToJava/CPPToJavaArchiveUpdateCallback.cpp
    ${JBINDING_CPP_DIR}/CPPToJava/CPPToJavaCryptoGetTextPassword.cpp
    ${JBINDING_CPP_DIR}/CPPToJava/CPPToJavaArchiveExtractCallback.cpp
    ${JBINDING_CPP_DIR}/CPPToJava/CPPToJavaArchiveOpenCallback.cpp
    ${JBINDING_CPP_DIR}/CPPToJava/CPPToJavaArchiveOpenVolumeCallback.cpp
    ${JBINDING_CPP_DIR}/CPPToJava/CPPToJavaProgress.cpp
    ${JBINDING_CPP_DIR}/CPPToJava/CPPToJavaSequentialInStream.cpp
    ${JBINDING_CPP_DIR}/CPPToJava/CPPToJavaInStream.cpp
    ${JBINDING_CPP_DIR}/CPPToJava/CPPToJavaSequentialOutStream.cpp
    ${JBINDING_CPP_DIR}/CPPToJava/CPPToJavaOutStream.cpp
)

add_library(7-Zip-JBinding SHARED
    ${JBINDING_CPP_FILES}
    ${SEVEN_ZIP_SOURCE_FILES}
)

find_library(log-lib log)
target_link_libraries(7-Zip-JBinding ${log-lib})

# Dead code elimination & export only JNI entry points
get_filename_component(JBINDING_VERSION_SCRIPT "${JBINDING_CPP_DIR}/PlatformUnix/lib7-Zip-JBinding.map" ABSOLUTE)
target_link_options(7-Zip-JBinding PRIVATE
    "-Wl,--gc-sections"
    "-Wl,--version-script=${JBINDING_VERSION_SCRIPT}"
    "-Wl,-z,max-page-size=16384"
    "-Wl,-z,common-page-size=16384"
)
set_target_properties(7-Zip-JBinding PROPERTIES LINK_DEPENDS "${JBINDING_VERSION_SCRIPT}")
