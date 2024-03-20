package com.example.springrabbitmqconsumer.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import com.example.springrabbitmqconsumer.entity.DealerType;
import com.example.springrabbitmqconsumer.repository.DealerTypeRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@Transactional(transactionManager = "transactionManager")
@SuppressWarnings("squid:S1226")
public class FileProcessService {

	@Autowired
	private DealerTypeRepository dealerTypeRepository;
	
	public void saveConsumeRecords(DealerType dealerType) {
		dealerTypeRepository.save(dealerType);
	}
}
