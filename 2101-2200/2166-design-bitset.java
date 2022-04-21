import java.util.*;

/*
 * 2166-design-bitset.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/04/20
 */
public class Bitset {
    static final byte[] FIX_MASK = new byte[] {
        (byte) (1 << 7), (byte) (1 << 6), (byte) (1 << 5), (byte) (1 << 4),
        (byte) (1 << 3), (byte) (1 << 2), (byte) (1 << 1), (byte) (1)
    };
    static final byte[] UNFIX_MASK = new byte[] {
        (byte) 0x7F, (byte) 0xBF, (byte) 0xDF, (byte) 0xEF,
        (byte) 0xF7, (byte) 0xFB, (byte) 0xFD, (byte) 0xFE
    };
    // local cache map;
    static final Map<Byte, char[]> BIN_CACHE_MAP = new HashMap<>(256);

    private int bitCount;
    private int size;
    private byte[] bitarr;

    public Bitset(int size) {
        this.bitCount = 0;
        this.size = size;
        int len = size / 8;
        if (size % 8 > 0) {
            len++;
        }
        bitarr = new byte[len];
    }

    public void fix(int idx) {
        int pos = idx / 8;
        int maskPos = idx % 8;
        byte origin = bitarr[pos];
        bitarr[pos] |= FIX_MASK[maskPos];
        if (origin != bitarr[pos]) {
            bitCount++;
        }
    }

    public void unfix(int idx) {
        int pos = idx / 8;
        int maskPos = idx % 8;
        byte origin = bitarr[pos];
        bitarr[pos] &= UNFIX_MASK[maskPos];
        if (origin != bitarr[pos]) {
            bitCount--;
        }
    }

    public void flip() {
        int len = size / 8;
        for (int i = 0; i < len; i++) {
            bitarr[i] = (byte) (~bitarr[i]);
        }
        int remainder = size % 8;
        for (int i = 0; i < remainder; i++) {
            if ((bitarr[len] & FIX_MASK[i]) != 0) {
                bitarr[len] &= UNFIX_MASK[i];
            } else {
                bitarr[len] |= FIX_MASK[i];
            }
        }

        bitCount = size - bitCount;
    }

    public boolean all() {
        return bitCount == size;
    }

    public boolean one() {
        return bitCount > 0;
    }

    public int count() {
        return bitCount;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (byte each : bitarr) {
            char[] bsArr = BIN_CACHE_MAP.computeIfAbsent(each, k -> {
                char[] chArr = new char[FIX_MASK.length];
                for (int i = 0; i < FIX_MASK.length; i++) {
                    if ((FIX_MASK[i] & k) != 0) {
                        chArr[i] = '1';
                    } else {
                        chArr[i] = '0';
                    }
                }
                return chArr;
            });
            sb.append(bsArr);
        }
        if (sb.length() > size) {
            sb.delete(size, sb.length());
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Bitset bs = new Bitset(55);
        bs.fix(3);
        bs.fix(1);
        bs.flip();
        // false
        System.out.println(bs.all());
        bs.unfix(0);
        bs.flip();
        // true
        System.out.println(bs.one());
        bs.unfix(0);
        // 2
        System.out.println(bs.count());
        // "01010"
        System.out.println(bs.toString());
    }
}
