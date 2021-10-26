public class Display1 {
    private int totalBits;
    private int freeBits;
    private int cpuSpeedModifier;
    private int creativity;


    public Display1(int b, int fB, int cSM, int c){
        totalBits = b;
        freeBits = fB;
        cpuSpeedModifier = cSM;
        creativity = c;
    }


    public String getStringTotalBits() { return "Total Bits Produced: " + String.valueOf(totalBits); }
    public String getStringFreeBits() { return "Usable Bits: " + String.valueOf(freeBits); }
    public String getStringCpuSpeed() { return "CPU Multiplier: %" + String.valueOf(cpuSpeedModifier); }
    public String getStringcreativity() { return "Total Creativity: " + String.valueOf(creativity); }
}
