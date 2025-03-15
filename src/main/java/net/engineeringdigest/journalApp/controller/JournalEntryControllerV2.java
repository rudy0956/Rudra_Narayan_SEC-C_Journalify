package net.engineeringdigest.journalApp.controller;

import net.engineeringdigest.journalApp.Service.JournalEntryService;
import net.engineeringdigest.journalApp.Service.UserService;
import net.engineeringdigest.journalApp.entity.JournalEntry;
import net.engineeringdigest.journalApp.entity.User;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.Getter;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController  @RequestMapping("/journal") public class JournalEntryControllerV2 {

@Autowired private JournalEntryService journalEntryService;
@Autowired private UserService userService;

//    localhost:8080/journal  GET
 @GetMapping("{username}") public ResponseEntity<?> getAllJournalEntriesOfUsers(@PathVariable String username) {

     User user = userService.findByUsername(username);
     List<JournalEntry> all = user.getJournalEntries();
     if (all != null && !all.isEmpty()) {
         return new ResponseEntity<>(all, HttpStatus.OK);
     }
     return new ResponseEntity<>(HttpStatus.NOT_FOUND);
 }

//    localhost:8080/journal POST
@PostMapping("{username}") public ResponseEntity<JournalEntry> createEntry(@RequestBody JournalEntry myEntry,@PathVariable String username){
    try{
        journalEntryService.saveEntry(myEntry,username);
        return new ResponseEntity<>(myEntry, HttpStatus.OK);
    }catch (Exception e){
        return new ResponseEntity<>( HttpStatus.BAD_REQUEST);
    }


}


@GetMapping("id/{myId}") public ResponseEntity<JournalEntry> getJournalEntry(@PathVariable ObjectId myId){


    Optional<JournalEntry> journalEntry= journalEntryService.findByID(myId);
    if(journalEntry.isPresent()){
        return new ResponseEntity<>(journalEntry.get(), HttpStatus.OK);
    }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

}
    @DeleteMapping("id/{myId}/{username}") ResponseEntity<?> deleteJournalEntry(@PathVariable ObjectId myId,@PathVariable String username){
       journalEntryService.deleteByID(myId,username);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
    @PutMapping("id/{username}/{myId}") public  ResponseEntity<?> updateJournalEntry(@PathVariable ObjectId myId,@PathVariable String username,@RequestBody JournalEntry newEntry){

        JournalEntry old=journalEntryService.findByID(myId).orElse(null);
        if(old !=null){
            old.setTitle(newEntry.getTitle()!=null && !newEntry.getTitle().equals("")? newEntry.getTitle() : old.getTitle());
            old.setContent(newEntry.getContent()!=null && !newEntry.equals("")? newEntry.getContent() : old.getContent());
            journalEntryService.saveEntry(old);
            return new ResponseEntity<>(old,HttpStatus.OK);
        }
       return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }
}
