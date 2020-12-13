package com.coursework.freelance.service;

import com.coursework.freelance.entity.Worker;
import com.coursework.freelance.repository.OrderRepository;
import com.coursework.freelance.repository.RoleRepository;
import com.coursework.freelance.repository.UserRepository;
import com.coursework.freelance.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkerService {

    @Autowired
    private WorkerRepository workerRepository;

    public Worker saveWorker(Worker worker) {
        return workerRepository.save(worker);
    }

    public Worker findById(Long id) {
        Optional<Worker> optionalWorker = workerRepository.findById(id);
        return optionalWorker.orElse(null);

    }

    public Worker findByLogin(String login) {
        return workerRepository.findByLogin(login);
    }

    public List<Worker> findAll() {
        return workerRepository.findAll();
    }
}
