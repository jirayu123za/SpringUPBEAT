package com.project.upbeat.Request;
import lombok.Data;

@Data
public class ConfigurationRequest{
    long rows;
    long cols;
    long init_plan_min;
    long init_plan_sec;
    long init_budget;
    long init_center_dep;
    long plan_rev_min;
    long plan_rev_sec;
    long rev_cost;
    long max_dep;
    double interest_pct;
}