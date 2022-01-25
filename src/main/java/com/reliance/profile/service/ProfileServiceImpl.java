package com.reliance.profile.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reliance.profile.exception.ProfileNotFoundException;
import com.reliance.profile.model.Profile;
import com.reliance.profile.repository.ProfileRepository;

@Service
public class ProfileServiceImpl implements ProfileService {

	@Autowired
	private ProfileRepository profileRepository;

	@Override
	public List<Profile> getProfiles() {
		List<Profile> profiles = profileRepository.findAll();
		return profiles;
	}

	@Override
	public List<Profile> getProfile(String id) {
		Optional<Profile> profile = profileRepository.findById(Integer.parseInt(id));
		if (profile.isPresent()) {
			return Arrays.asList(profile.get());
		}
		return null;
	}

	@Override
	public Profile createProfile(Profile profile) {
		Profile dbProfile = profileRepository.save(profile);
		return dbProfile;
	}

	@Override
	public Profile updateProfile(Integer id, Profile profile) {
		Optional<Profile> dbProfile = profileRepository.findById(id);
		if (!dbProfile.isPresent()) {
			System.out.println("Profile does not exist in the database!");
			throw new ProfileNotFoundException("Profile does not exist in the database!");
		} else {
			Profile toBeUpdated = dbProfile.get();
			toBeUpdated.setName(profile.getName());
			toBeUpdated.setAddress(profile.getAddress());
			Profile updatedProfile = profileRepository.save(toBeUpdated);
			return updatedProfile;
		}
	}

	@Override
	public void deleteProfile(Integer id) {
		Optional<Profile> dbProfile = profileRepository.findById(id);
		if (dbProfile.isPresent()) {
			profileRepository.delete(dbProfile.get());
			System.out.println("profile has been deleted: " + id);
		} else {
			System.out.println("Profile Does Not Found!");
			throw new ProfileNotFoundException("Profile does not exist in the database!");
		}
	}

}
