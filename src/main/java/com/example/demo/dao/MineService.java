package com.example.demo.dao;

import com.example.demo.entity.Mine;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MineService {

    @Autowired
    MineRepository mineRepository;

    public List<Mine> getAllMines(){
        List<Mine> mines = Lists.newArrayList(mineRepository.findAll());
        return mines;
    }

    public Mine getMine(Mine mine){
        List<Mine> mines;
        if (mine.getCodNtnMine() != null){
            mines = mineRepository.findByNTN(mine.getCodNtnMine());
        }
        else {
            mines = mineRepository.findByName(mine.getNamMine());
        }
        if (mines.isEmpty())
            return null;
        else
            return mines.get(0);

    }

    public boolean updateMine(Mine mine){
        Mine update = mineRepository.save(mine);
        if (update != null)
            return true;
        else
            return false;
    }
}
