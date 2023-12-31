package com.fdmgroup.springboot.Service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdmgroup.springboot.Model.Movie;
import com.fdmgroup.springboot.Model.User;
import com.fdmgroup.springboot.Repository.MovieRepository;
import com.fdmgroup.springboot.Repository.UserRepository;


@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	MovieRepository movieRepository;
	
    private static final Logger LOGGER = LogManager.getLogger(UserService.class);

	
	 

	// Create
	public User addUser(User user) {
		User savedUser = userRepository.save(user);

		return savedUser;
	}

	// Read
	public User getUser(String userName) {
		Optional<User> user = userRepository.findById(userName);

		if (user.isPresent())
			return user.get();
		else
			return null;
	}

	// Update
	public User updateUser(User user) {
		User updatedUser = userRepository.save(user);

		return updatedUser;
	}

	// Delete
	public void deleteUser(String userName) {
		userRepository.deleteById(userName);
	}

	// Favorites for a user
	public List<Movie> getFavourites(String userName) {
		User user = userRepository.findById(userName).get();

		return user.getFavourites();
	}
	
	//Watchlist
	public List<Movie> getWatchList(String userName) {
		User user = userRepository.findById(userName).get();

		return user.getWatchlist();
	}
	
	public void addFollowing(String userName, User user) {
		User foundUser = userRepository.findById(userName).get();
		
		foundUser.addFollowing(user);
		
		LOGGER.info(foundUser);

		userRepository.save(foundUser);
	}
}
