package com.example.pathfinder.service;

import com.example.pathfinder.domain.dto.view.MostCommentedRouteViewDto;
import com.example.pathfinder.domain.entities.Route;
import com.example.pathfinder.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class RouteService {
    private final RouteRepository routeRepository;

    @Autowired
    public RouteService(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }

    public MostCommentedRouteViewDto getMostCommented() {
        Route route = this.routeRepository
                .findMostCommented()
                .orElseThrow(NoSuchElementException::new)
                .get(0);

        return MostCommentedRouteViewDto.fromRoute(route);
    }
}
