package myEverything.core.model;

public class Thing {
    private String name;//名称
    private String path;//路径
    private  Integer depth;//深度
    private FileType fileType;//文件类型

    @Override
    public String toString() {
        return "Thing{" +
                "name='" + name + '\'' +
                ", path='" + path + '\'' +
                ", depth=" + depth +
                ", fileType=" + fileType +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setDepth(Integer depth) {
        this.depth = depth;
    }

    public void setFileType(FileType fileType) {
        this.fileType = fileType;
    }

    public String getName() {

        return name;
    }

    public String getPath() {
        return path;
    }

    public Integer getDepth() {
        return depth;
    }

    public FileType getFileType() {
        return fileType;
    }
}
