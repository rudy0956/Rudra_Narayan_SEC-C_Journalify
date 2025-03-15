package net.engineeringdigest.journalApp.Service;

import net.engineeringdigest.journalApp.Repository.JournalEntryRepository;
import net.engineeringdigest.journalApp.Repository.UserRepository;
import net.engineeringdigest.journalApp.entity.JournalEntry;
import net.engineeringdigest.journalApp.entity.User;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public  class UserService {
    @Autowired
    private UserRepository userRepository;

    public void saveEntry(User user){
        userRepository.save(user);
    }

    public List<User> getAll(){
        return userRepository.findAll();
    }
    public Optional<User> findByID(ObjectId myId){
        return Optional.ofNullable(userRepository.findById(myId).orElse(null));
    }
    public void deleteByID(ObjectId myId){
               userRepository.deleteById(myId);
    }

    public User findByUsername(String username){
        return userRepository.findByUsername(username);
    }
}



//Controller---->Service---->Repository