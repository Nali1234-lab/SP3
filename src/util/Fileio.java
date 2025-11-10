package util;

import java.util.List;

    public class FileIO {
        //attribut
        private String userFile;

        //constructor
        public FileIO() {
            this.userFile = "users.txt"; //vores filename kunne ændres?
        }

        //metoder
        public void saveUsers(List<User> users) {
            //skal gemme brugere til file
        }

        public List<User> loadUsers() {
            //skal indlæse brugere fra file
            return null;
        }
    }
}
