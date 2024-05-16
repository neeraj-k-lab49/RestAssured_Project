package models;

public class PostModel {

    private int id;

    private String name;

    private String job;

    private int userId;

    public PostModel() {
    }

    public PostModel(String nane) {
        setName(nane);
    }

    public PostModel(int userId, int id, String name, String job) {
        setId(id);
        setName(name);
        setJob(job);
        setUserId(userId);
    }

    public PostModel(int userId, String name, String job) {
        setName(name);
        setJob(job);
        setUserId(userId);
    }

    public PostModel(String name, String job) {
        setName(name);
        setJob(job);
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
}
