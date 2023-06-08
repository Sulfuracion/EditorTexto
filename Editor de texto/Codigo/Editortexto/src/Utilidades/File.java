package Utilidades;

import java.util.Date;

class File {
    private String name;
    private String content;
    private Date creationDate;

    public File(String name, String content, Date creationDate) {
        this.name = name;
        this.content = content;
        this.creationDate = creationDate;
    }

    public File(String nombre, String contenido) {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}
