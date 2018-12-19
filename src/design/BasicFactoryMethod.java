package design;


import java.io.Serializable;
enum CType{
    PC,SERVER
}
abstract class Compter{
    public  abstract String getCPU();
    public  abstract String getGPU();
    public  abstract String getRAM();
    public  abstract String getSSD();

    @Override
    public String toString() {
        return "RAM="+this.getRAM()
                 +"CPU"+this.getCPU()
                +"GPU"+this.getGPU()
                +"CPU"+this.getCPU()
                +"CPU"+this.getCPU();



    }
}
class PC extends Compter{
    private String rom;
    private String cpu;
    private String gpu;
    private  String ssd;

    public void PC(String rom,String cpu,String gpu,String ssd) {
        this.rom = rom;
        this.cpu=cpu;
        this.gpu=gpu;
        this.ssd=ssd;
    }

    public String getRom() {
        return rom;
    }

    public String getSsd() {
        return ssd;
    }

    public String getGpu() {
        return gpu;
    }

    public String getCpu() {
        return cpu;
    }

    @Override
    public String getCPU() {
        return null;
    }

    @Override
    public String getGPU() {
        return null;
    }

    @Override
    public String getRAM() {
        return null;
    }

    @Override
    public String getSSD() {
        return null;
    }
}

class Server extends Compter{
    private String rom;
    private String cpu;
    private String gpu;
    private  String ssd;

    public void Server(String rom,String cpu,String gpu,String ssd) {
        this.rom = rom;
        this.cpu=cpu;
        this.gpu=gpu;
        this.ssd=ssd;
    }

    public String getRom() {
        return rom;
    }

    public String getSsd() {
        return ssd;
    }

    public String getGpu() {
        return gpu;
    }

    public String getCpu() {
        return cpu;
    }

    @Override
    public String getCPU() {
        return null;
    }

    @Override
    public String getGPU() {
        return null;
    }

    @Override
    public String getRAM() {
        return null;
    }

    @Override
    public String getSSD() {
        return null;
    }
}
class ComperFactory{
    public   static  Compter produceComputer(CType type,String rom,String cpu,String gpu,String ssd) {
        Compter compter = null;
        if (CType.PC == type) {
            compter = new PC(rom, cpu, gpu, ssd);

        } else if (CType.SERVER == type) {
            compter = new Server(rom, cpu, gpu, ssd);
        } else {
            throw new Exception();
        }


    }
}
public class BasicFactoryMethod {
    public static void main(String[] args) {
        Compter pc=ComperFactory.produceComputer(CType.PC,"i9","inter","32","512");
        System.out.println(pc);
        Compter server=ComperFactory.produceComputer(CType.SERVER,"i9","inter","32","512");
        System.out.println(server);


    }



}
