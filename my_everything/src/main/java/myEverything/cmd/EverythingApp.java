package myEverything.cmd;

import lombok.Getter;
import myEverything.core.EverythingManager;
import myEverything.core.model.Condition;

import java.util.Scanner;

@Getter
public class EverythingApp {
    public static void main(String[] args) {

        //1.Everythingmanager
        EverythingManager manager=EverythingManager.getInstance();

        //交互式的命令行
        Scanner scanner=new Scanner(System.in);
        System.out.println("欢迎使用everything");
        while (true){
            System.out.print(">>");
            String line=scanner.nextLine();
            switch (line){
                case "help":{
                    manager.help();
                    break;
                }

                case "quit":{
                    manager.quit();
                    break;
                }

                case "index":{
                    manager.buildIndex();
                    break;
                }

                default:{
                        if (line.startsWith("search")){
                            //解析参数
                            String[] segments=line.split(" ");
                            if (segments.length>=2){
                                Condition condition=new Condition();
                                String name=segments[1];
                               condition.setName(name);
                               if (segments.length>=3){
                                   String type=segments[2];
                                   //用户输入的文件类型大小写不一定
                                   condition.setFiletype(type.toUpperCase());
                               }
                               //
                               manager.search(condition).forEach(thing->{
                                   System.out.println(thing.getPath());
                               });
                            }else {
                                manager.help();
                                //长度小于2，参数不符合
                            }
                        }else {
                            manager.help();
                        }
                    }
            }

        }
    }
}
