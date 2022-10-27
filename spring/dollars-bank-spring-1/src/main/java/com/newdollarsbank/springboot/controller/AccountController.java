package com.newdollarsbank.springboot.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.newdollarsbank.springboot.exception.AccountNotFoundException;
import com.newdollarsbank.springboot.model.Account;
import com.newdollarsbank.springboot.repository.AccountRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class AccountController {
	
	@Autowired
	AccountRepository accountRepository;
	
	//api to get all accounts (READ)
	@GetMapping("/accounts")
	public List<Account> getAllAccounts() {
		return accountRepository.findAll();
	}
	
	//api to retrieve an account (READ)
	@GetMapping("/accounts/{id}")
	public Optional<Account> get(@PathVariable Long id) {
		return accountRepository.findById(id);
	}
	
	//api to create an account (CREATE)
	@PostMapping("/accounts") 
	public ResponseEntity<Object> createAccount(@RequestBody Account account) {
		Account savedAccount = accountRepository.save(account);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedAccount.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	//api to update an account (UPDATE)
	@PutMapping("/accounts/{id}") 
	public Account updateAccount(@PathVariable(value = "id") Long accountId, @RequestBody Account accountDetails) {
		Optional<Account> account = Optional.of(accountRepository.findById(accountId).orElseThrow(() -> new AccountNotFoundException("we could not find the account. sorry")));
		account.get().setName(accountDetails.getName());
		account.get().setUserid(accountDetails.getUserid());
		account.get().setPin(accountDetails.getPin());
		account.get().setAmount(accountDetails.getAmount());
		
		Account updatedAccount = accountRepository.save(accountDetails);
		return updatedAccount;
	}
	
	//api to delete an account (DELETE)
	@DeleteMapping("/accounts/{id}")
	public ResponseEntity<?> deleteAccount(@PathVariable(value = "id") Long accountId) {
		Account account = accountRepository.findById(accountId).orElseThrow(() -> new AccountNotFoundException("we could not find the account the the id to delete. sorry"));
		accountRepository.delete(account);
		return ResponseEntity.ok().build();
	}
}
