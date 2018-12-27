package design;

import java.io.IOException;

interface  CommandExecutor{
    void runCommand(String cmd) throws IOException, Exception;
}
class  CommandExecutorImpl implements CommandExecutor{

    @Override
    public void runCommand(String cmd)throws IOException {
        Runtime.getRuntime().exec(cmd);
        System.out.println(""+cmd+"command sucess");
    }
}
class  CommansExexutorProxy implements  CommandExecutor{
    private  boolean isAdmain;
    private CommandExecutor executor;

    public CommansExexutorProxy(String user,String pwd){
        if("damo".equals(user)&&"2018".equals(pwd)){
            isAdmain=true;
        }
        executor=new CommandExecutorImpl();
    }
    @Override
    public void runCommand(String cmd) throws Exception{
        if(!isAdmain &&cmd.trim().startsWith("rm")){
                throw  new Exception("rm command is allowed for non-admin");
            }else{
                executor.runCommand(cmd);
            }
        }
    }

public class SimpleProxy {
    public static void main(String[] args) {
        CommandExecutor executor = new CommansExexutorProxy("text", "2018");
        try {

            executor.runCommand("ls -l");
            executor.runCommand("rm -rf text.pdf");
        } catch (Exception e) {
            System.out.println("exception message" + e.getMessage());
        }
    }

}
