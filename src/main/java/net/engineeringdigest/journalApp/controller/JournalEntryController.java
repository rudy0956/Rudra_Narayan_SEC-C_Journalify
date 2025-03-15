package net.engineeringdigest.journalApp.controller;

import net.engineeringdigest.journalApp.entity.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController @RequestMapping("/_journal") public class JournalEntryController {

//Table(adding or removing entries)
//we are using fields because no external database is involved

    private Map<Long, JournalEntry> journalEntries=new HashMap<>();


//    localhost:8080/journal  GET
 @GetMapping public List<JournalEntry> getAll(){
          return new ArrayList<>(journalEntries.values());
}


//    localhost:8080/journal POST
@PostMapping public boolean createEntry(@RequestBody JournalEntry myEntry){
//journalEntries.put(myEntry.getId(), myEntry);
return true;
}


@GetMapping("id/{myId}") public JournalEntry getJournalEntry(@PathVariable Long myId){
     return journalEntries.get(myId);
}
    @DeleteMapping("id/{myId}") public JournalEntry deleteJournalEntry(@PathVariable Long myId){
        return journalEntries.get(myId);
    }
    @PutMapping("id/{myId}") public JournalEntry updateJournalEntry(@PathVariable Long myId,@RequestBody JournalEntry myEntry){
        return journalEntries.put(myId,myEntry);
    }
}
