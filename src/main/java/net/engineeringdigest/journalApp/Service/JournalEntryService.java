package net.engineeringdigest.journalApp.Service;

import net.engineeringdigest.journalApp.Repository.JournalEntryRepository;
import net.engineeringdigest.journalApp.entity.JournalEntry;
import net.engineeringdigest.journalApp.entity.User;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public  class JournalEntryService {
    @Autowired
    private JournalEntryRepository journalEntryRepository;
@Autowired private  UserService userService;

    @Transactional public void saveEntry(JournalEntry journalEntry, String username){
        User user= userService.findByUsername(username);
        journalEntry.setDate(LocalDateTime.now());
        JournalEntry Saved = journalEntryRepository.save(journalEntry);
//        List me add krna for a particular user
        user.getJournalEntries().add(Saved);
//        user.setUsername(null);
//        user save hua with new database entry
        userService.saveEntry(user);
    }
    public void saveEntry(JournalEntry journalEntry){

        journalEntryRepository.save(journalEntry);
    }

    public List<JournalEntry> getAll(){
        return journalEntryRepository.findAll();
    }
    public Optional<JournalEntry> findByID(ObjectId myId){
        return Optional.ofNullable(journalEntryRepository.findById(myId).orElse(null));
    }  public void deleteByID(ObjectId myId, String username){
        User user= userService.findByUsername(username);
//        user.getJournalEntries().removeIf(x ->x.getId().equals(myId));
        userService.saveEntry(user);
        journalEntryRepository.deleteById(myId);
    }
}



//Controller---->Service---->Repository