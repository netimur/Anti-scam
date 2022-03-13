package com.example.antiscam;

public class SafeNumberResponse {
    private final boolean verdict;

    public SafeNumberResponse(boolean verdict) {
        this.verdict = verdict;
    }

    public boolean isVerdict() {
        return verdict;
    }
}
