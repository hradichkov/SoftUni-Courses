package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.ImportAgentsDTO;
import softuni.exam.models.entity.Agent;
import softuni.exam.models.entity.Town;
import softuni.exam.repository.AgentRepository;
import softuni.exam.repository.TownRepository;
import softuni.exam.service.AgentService;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import static softuni.exam.util.PathFiles.AGENTS_PATH;

@Service
public class AgentServiceImpl implements AgentService {

    private final AgentRepository agentRepository;
    private final TownRepository townRepository;

    private final ModelMapper modelMapper;
    private final Gson gson;
    private final Validator validator;

    public AgentServiceImpl(AgentRepository agentRepository, TownRepository townRepository, ModelMapper modelMapper, Gson gson, Validator validator) {
        this.agentRepository = agentRepository;
        this.townRepository = townRepository;

        this.modelMapper = modelMapper;
        this.gson = gson;
        this.validator = validator;
    }

    @Override
    public boolean areImported() {
        return this.agentRepository.count() > 0;
    }

    @Override
    public String readAgentsFromFile() throws IOException {
        return Files.readString(AGENTS_PATH);
    }

    @Override
    public String importAgents() throws IOException {
        String json = this.readAgentsFromFile();

        ImportAgentsDTO[] importAgentsDTOS = this.gson.fromJson(json, ImportAgentsDTO[].class);

        return Arrays.stream(importAgentsDTOS)
                .map(this::importAgent)
                .collect(Collectors.joining(System.lineSeparator()));
    }

    private String importAgent(ImportAgentsDTO dto) {
        Set<ConstraintViolation<ImportAgentsDTO>> errors =
                this.validator.validate(dto);

        if (!errors.isEmpty()) {
            return "Invalid agent";
        }

        Optional<Agent> optAgent = this.agentRepository.findByFirstName(dto.getFirstName());

        if (optAgent.isPresent()) {
            return "Invalid agent";
        }
        Optional<Town> town = this.townRepository.findByTownName(dto.getTownName());

        Agent agent = this.modelMapper.map(dto, Agent.class);
        agent.setTown(town.get());

        this.agentRepository.save(agent);

        return "Successfully imported agent - " + agent.getFirstName() + " " + agent.getLastName();
    }
}
