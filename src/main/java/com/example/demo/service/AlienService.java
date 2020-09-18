package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.AlienRepository;
import com.example.demo.model.AlienModel;

@Service
public class AlienService {
	@Autowired
	private AlienRepository alienRepository;

	public List<AlienModel> list() {
		return alienRepository.findAll();
	}
}
