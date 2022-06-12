package proxy.jdkproxy;


public interface PersonBean {
    String getName();
    String getGender();
    String getInterest();
    int getHotOrNotRating();

    void setName(String name);
    void setGender(String gender);
    void setInterest(String interest);
    void setHotOrNotRating(int rating);
}
