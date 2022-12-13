package com.example.school_project.homeModel;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class HomeModel implements Serializable {
    private List<DataArray> data_array;

    public List<DataArray> getData_array() {
        return data_array;
    }

    public void setData_array(List<DataArray> data_array) {
        this.data_array = data_array;
    }
}
