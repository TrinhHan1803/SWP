
package User;

public class UserDTO {
    private String username;
    private String password;
    private boolean active;
    private String email;
    private String groupUser;

    public UserDTO() {
    }

    public UserDTO(String username, String password, boolean active, String email, String groupUser) {
        this.username = username;
        this.password = password;
        this.active = active;
        this.email = email;
        this.groupUser = groupUser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGroupUser() {
        return groupUser;
    }

    public void setGroupUser(String groupUser) {
        this.groupUser = groupUser;
    }
    
    
}
