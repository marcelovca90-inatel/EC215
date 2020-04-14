package io.github.marcelovca90.datacomp;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RunLengthEncodingTest
{
    private static final String RAW_DATA = "MMaaaaarrrcceeeelooo";
    private static final String ENCODED_DATA = "2\0M5\0a3\0r2\0c4\0e1\0l3\0o";

    private final RunLengthEncoding rle = new RunLengthEncoding();

    @Test(expected = IllegalArgumentException.class)
    public void compressString_withInvalidData_shouldThrowException()
    {
        // given
        String input = new String(new char[0]);

        // when
        rle.compress(input);
    }

    @Test
    public void compressString_withValidData_shouldCompress()
    {
        // given
        String input = RAW_DATA;
        String expected = ENCODED_DATA;

        // when
        String output = rle.compress(input);

        // then
        assertEquals(expected, output);
    }

    @Test
    public void compressByteArray_withValidData_shouldCompress()
    {
        // given
        byte[] input = RAW_DATA.getBytes();
        byte[] expected = ENCODED_DATA.getBytes();

        // when
        byte[] output = rle.compress(input);

        // then
        assertArrayEquals(expected, output);
    }

    @Test(expected = IllegalArgumentException.class)
    public void decompressString_withInvalidData_shouldThrowException()
    {
        // given
        String input = new String(new char[0]);

        // when
        rle.decompress(input);
    }

    @Test
    public void decompressString_withValidData_shouldDecompress()
    {
        // given
        String input = ENCODED_DATA;
        String expected = RAW_DATA;

        // when
        String output = rle.decompress(input);

        // then
        assertEquals(expected, output);
    }

    @Test
    public void decompressByteArray_withValidData_shouldDecompress()
    {
        // given
        byte[] input = ENCODED_DATA.getBytes();
        byte[] expected = RAW_DATA.getBytes();

        // when
        byte[] output = rle.decompress(input);

        // then
        assertArrayEquals(expected, output);
    }
}
