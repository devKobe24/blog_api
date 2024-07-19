package com.devkobe.blog.service.dateInfo;

import com.devkobe.blog.domain.dateInfo.DateInfo;
import com.devkobe.blog.repository.dateInfo.DateInfoRepository;
import com.devkobe.blog.web.dto.dateInfo.DateInfoResponseDto;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class DateInfoService {

	private final DateInfoRepository dateInfoRepository;

	// CREATE
	@Transactional
	public Long save(DateInfo dateInfo) {
		return dateInfoRepository.save(dateInfo).getId();
	}

	// READ
	@Transactional(readOnly = true)
	public List<DateInfoResponseDto> findAll() {
		return dateInfoRepository.findAll().stream()
		                         .map(DateInfoResponseDto::new)
		                         .collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public DateInfo findById(Long id) {
		return dateInfoRepository.findById(id)
		                         .orElseThrow(() -> new IllegalArgumentException("Invalid dateInfo ID: " + id));
	}

	// UPDATE
	@Transactional
	public Long update(Long id, DateInfo updatedDateInfo) {
		DateInfo dateInfo = dateInfoRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid dateInfo ID: " + id));

		dateInfo.setReleaseDate(updatedDateInfo.getReleaseDate());
		dateInfo.setModificationDate(updatedDateInfo.getModificationDate());
		dateInfo.setPosts(updatedDateInfo.getPosts());

		return dateInfo.getId();
	}

	// DELETE
	@Transactional
	public void deleteById(Long id) {
		DateInfo dateInfo = dateInfoRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid dateInfo ID: " + id));
		dateInfoRepository.delete(dateInfo);
	}
}
