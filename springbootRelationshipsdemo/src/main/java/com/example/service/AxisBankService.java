package com.example.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.OnetoManyEntity.AxisBankCards;
import com.example.OnetoManyEntity.AxisBankCustomer;
import com.example.repo.AxisBankRepository;

@Service
public class AxisBankService {
	@Autowired
	AxisBankRepository axisRepo;

	public AxisBankCustomer addBankCustomerInDB(AxisBankCustomer axis) {
		AxisBankCustomer savedObj = axisRepo.save(axis);
		return savedObj;
	}

	public AxisBankCustomer getBankCustomerDetails(int id) {
		Optional<AxisBankCustomer> optionalBankCustomer = axisRepo.findById(id);
		AxisBankCustomer axisBankCustomer = optionalBankCustomer.get();
		return axisBankCustomer;
	}

	public AxisBankCustomer getCardDetails(int id) {
		Optional<AxisBankCustomer> optionalCard = axisRepo.findById(id);
		AxisBankCustomer cust = optionalCard.get();
		List<AxisBankCards> listofCards = cust.getCard();
		List<AxisBankCards> validCardList = (List<AxisBankCards>) listofCards.stream()
				.filter(card -> card.getExpiryDate().compareTo(LocalDate.now()) < 0).collect(Collectors.toList());
		cust.setCard(validCardList);
		return cust;
	}

	@Transactional
	public AxisBankCustomer updateCardDetails(AxisBankCustomer customerFromPayload) {

		Optional<AxisBankCustomer> optionalCustomerFromDB = axisRepo.findById(customerFromPayload.getCustomerId());
		if (optionalCustomerFromDB.isPresent()) {
			AxisBankCustomer customerFromDB = optionalCustomerFromDB.get();
			if (customerFromPayload.getName() != null) {
				customerFromDB.setName(customerFromPayload.getName());
			}
			if (customerFromPayload.getEmailId() != null) {
				customerFromDB.setEmailId(customerFromPayload.getEmailId());
			}
			List<AxisBankCards> cardsToUpdate = customerFromPayload.getCard();
			if (cardsToUpdate != null) {

				List<Integer> listOfCardIds = cardsToUpdate.stream().map(e -> e.getCardId())
						.collect(Collectors.toList());

				List<AxisBankCards> cardsFromDB = customerFromDB.getCard();
				List<AxisBankCards> cardsFromDBToUpdate = cardsFromDB.stream()
						.filter(card -> listOfCardIds.contains(card.getCardId())).collect(Collectors.toList());

				for (AxisBankCards card : cardsToUpdate) {
					AxisBankCards dbCard = cardsFromDBToUpdate.stream()
							.filter(cardInDB -> cardInDB.getCardId() == (card.getCardId())).findFirst().get();
					if (card.getCardName() != null) {
						dbCard.setCardName(card.getCardName());
					}
					if (card.getExpiryDate() != null) {
						dbCard.setExpiryDate(card.getExpiryDate());
					}
					if (card.getIssuedDate() != null) {
						dbCard.setIssuedDate(card.getIssuedDate());
					}
				}
			}
			return customerFromDB;
		}
		return null;

	}

}
