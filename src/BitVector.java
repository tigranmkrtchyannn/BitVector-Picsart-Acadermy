public class BitVector {
    private int size;
    private int[] bitArr;


    public BitVector(int initialSize) {
        this.size = (initialSize / 32) + 1;
        bitArr = new int[this.size];
    }

    public void set(int index) {
        if (index < 0 && index > size) {
            throw new ArrayIndexOutOfBoundsException("Inavlid index ...");
        }
        int newIndex = (index / 32);
        int bitIndex = index % 32;
        bitArr[newIndex] |= (1 << bitIndex);
    }

    public void reset(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("Invalid Index...");
        }
        int newIndex = index / 32;
        int bitIndex = index % 32;
        bitArr[newIndex] ^= (1 << bitIndex);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < bitArr.length; i++) {
            str.append(Integer.toBinaryString(bitArr[i]));
        }
        return str.toString();
    }



}
