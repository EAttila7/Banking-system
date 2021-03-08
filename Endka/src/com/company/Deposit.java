package com.company;

public class Deposit extends Client  {
    private int dep_id;
    private int percent;
    private long sum;
    private int term;

    public Deposit() {

    }

//    public Deposit(double percent, long sum, int term) {
//        setPercent(percent);
//        setSum(sum);
//        setTerm(term);
//    }

    public Deposit( int id,int percent, long sum, int term, Client client) {
        super.setId(id);
        setPercent(percent);
        setSum(sum);
        setTerm(term);

    }


    public int getDep_id() {
        return dep_id;
    }

    public void setDep_id(int dep_id) {
        this.dep_id = dep_id;
    }

    public int getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }

    public long getSum() {
        return sum;
    }

    public void setSum(long sum) {
        this.sum = sum;
    }

    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
    }


    @Override
    public String toString() {
        return "Deposit{" +
                "dep_id=" + dep_id +
                ", percent=" + percent +
                ", sum=" + sum +
                ", term=" + term +
                '}';
    }
}
