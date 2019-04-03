package myEverything.config;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Setter
@Getter
@ToString
//配置类---单例
public class EverythingConfig {
    private static volatile EverythingConfig config;
    //volatile:内存可见性，禁止指令重排

    private Boolean orderByDesc=false;//检索结果深度排序，默认升序false
    private Integer maxReturn=30;//最大检索返回数量

    private HandlerPath handlerPath=HandlerPath.getDefaultHandlerPath();//处理路径

    private Boolean enableBuildIndex=false;//是否开启索引，默认关闭，通过index功能指令开启索引




    private EverythingConfig(){
    }
    public static EverythingConfig getInstance(){
        if (config==null){
            synchronized (EverythingConfig.class){
                if (config==null){
                    config=new EverythingConfig();
                }
            }
        }
        return config;
    }

//    public static void main(String[] args) {
//        System.out.println(EverythingConfig.getInstance());
//    }getInstance

}
