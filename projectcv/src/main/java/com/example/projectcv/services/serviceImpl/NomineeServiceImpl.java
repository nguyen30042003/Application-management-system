package com.example.projectcv.services.serviceImpl;

import com.example.projectcv.dto.request.NomineeDTO;
import com.example.projectcv.dto.response.ApiResponse;
import com.example.projectcv.entity.Nominee;
import com.example.projectcv.exception.AppException;
import com.example.projectcv.exception.ErrorCode;
import com.example.projectcv.repository.NomineeRepository;
import com.example.projectcv.services.NomineeService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class NomineeServiceImpl implements NomineeService {
    private NomineeRepository nomineeRepository;
    @Override
    public Page<Nominee> getNominee(Pageable pageable) {
        return nomineeRepository.findAll(pageable);
    }

    @Override
    public ApiResponse<Nominee> getByID(Long id) {
        Optional<Nominee> nominee = nomineeRepository.findById(id);
        if(nominee.isPresent())
        {
            return new ApiResponse<>(nominee.get());
        }
        else{
            throw new AppException(ErrorCode.NOMINEE_NOT_EXISTED);

        }

    }

    @Override
    public ApiResponse<Nominee> update(Long id, NomineeDTO nomineeDTO) {
        Nominee nominee = getByID(id).getData();
        nominee.setName(nomineeDTO.getName());
        nominee.setDescription(nomineeDTO.getDescription());
        return new ApiResponse<>(nomineeRepository.saveAndFlush(nominee));
    }


    @Override
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public ApiResponse<Nominee> create(NomineeDTO nomineeDTO) {
        Nominee nominee = new Nominee();
        nominee.setName(nomineeDTO.getName());
        nominee.setDescription(nomineeDTO.getDescription());
        return new ApiResponse<>(nomineeRepository.saveAndFlush(nominee));
    }

    @Override
    public void delete(Long id) {
        Nominee nominee = getByID(id).getData();
        nomineeRepository.delete(nominee);
    }
}
