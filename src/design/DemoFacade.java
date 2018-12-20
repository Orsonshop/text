package design;

import java.sql.Connection;

class Mysqlhelper{
     public static Connection getMysqlDBCConnection(){
        System.out.println("get");
        return  null;

    }
    public void genertMysqlPDFRecport(String table,Connection con){
        System.out.println("MYSQL " +con+"form "+table);

    }
    public void genertMysqlHTMLRecport(String table,Connection con){
        System.out.println("MYSQL " +con+"form "+table);

    }
 }
class Oraclehelper{
    public static Connection getOracleDBCConnection(){
        System.out.println("get");
        return  null;

    }
    public void genertOraclePDFRecport(String table,Connection con){
        System.out.println("Oracle " +con+"form "+table);

    }
    public void genertOracleHTMLRecport(String table,Connection con){
        System.out.println("Oracle " +con+"form "+table);

    }
}
class FacadeHelper{
    enum  DBTType{
        MYSQL,ORACLE
    }
    enum  ReportType{
        MPDF,HTML
    }
    public static void genertereprport(DBTType datype,ReportType reportType ,String tablename){
        Connection con=null;
        switch (datype){
            case MYSQL:
                con=Mysqlhelper.getMysqlDBCConnection();
                Mysqlhelper mysqlhelper=new Mysqlhelper();
                switch (reportType){
                    case HTML:
                        mysqlhelper.genertMysqlHTMLRecport(tablename,con);
                        break;
                    case MPDF:
                        mysqlhelper.genertMysqlHTMLRecport(tablename,con);
                        break;
                }
                break;
            case ORACLE:
                con=Oraclehelper.getOracleDBCConnection();
                Oraclehelper oraclehelper=new Oraclehelper();
                switch (reportType){
                    case HTML:
                        oraclehelper.genertOracleHTMLRecport(tablename,con);
                        break;
                    case MPDF:
                        oraclehelper.genertOraclePDFRecport(tablename,con);
                        break;
                }
                break;

        }
    }
}
public class DemoFacade {
    public static void main(String[] args) {
        String tablename="Student";

//        Connection con=Mysqlhelper.getMysqlDBCConnection();
//        Mysqlhelper mysqlhelper=new Mysqlhelper();
//        mysqlhelper.genertMysqlHTMLRecport(tablename,con);
//
//
//        Connection con2=Oraclehelper.getOracleDBCConnection();
//        Oraclehelper oraclehelper=new Oraclehelper();
//        oraclehelper.genertOracleHTMLRecport(tablename,con2);


        FacadeHelper.genertereprport(FacadeHelper.DBTType.MYSQL,FacadeHelper.ReportType.MPDF,tablename);

        FacadeHelper.genertereprport(FacadeHelper.DBTType.ORACLE,FacadeHelper.ReportType.HTML,tablename);
    }

}
