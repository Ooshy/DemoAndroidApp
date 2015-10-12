package savannahchrisroy.demo.pojo;

/**
 * Created by Chris on 10/10/2015.
 */
public class Topic {

    public Class getActivity() {
        return activity;
    }

    public void setActivity(Class activity) {
        this.activity = activity;
    }

    Class activity;

    public Topic(String name, Class activity) {
        this.name = name;
        this.activity = activity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    String name;

}
