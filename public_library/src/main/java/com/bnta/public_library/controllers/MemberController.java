package com.bnta.public_library.controllers;

import com.bnta.public_library.models.Book;
import com.bnta.public_library.models.Member;
import com.bnta.public_library.repositories.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("members")
public class MemberController {

    @Autowired
    MemberRepository memberRepository;

    // INDEX
    @GetMapping
    public ResponseEntity<List<Member>> getMembers() {
        return new ResponseEntity(memberRepository.findAll(), HttpStatus.OK);
    }

    // SHOW
    @GetMapping("/{id}")
    public ResponseEntity<Member> getMember(@PathVariable Long id) {
        var found = memberRepository.findById(id);
        return new ResponseEntity(found, found.isEmpty() ? HttpStatus.NOT_FOUND : HttpStatus.OK);
    }

    // POST
    @PostMapping
    public ResponseEntity<Member> createMember(@RequestBody Member newMember) {
        memberRepository.save(newMember);
        return new ResponseEntity(newMember, HttpStatus.CREATED);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<List<Member>> deleteMember(@PathVariable Long id) {
        var found = memberRepository.findById(id);
        memberRepository.deleteById(id);
        return new ResponseEntity(memberRepository.findAll(), found.isEmpty() ? HttpStatus.NOT_FOUND : HttpStatus.ACCEPTED);
    }
}
