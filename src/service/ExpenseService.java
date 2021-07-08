package service;

import model.Expense;

import java.util.ArrayList;
import java.util.List;

public class ExpenseService {

    private static List<Expense> expenseDB = new ArrayList<>();

    public static void saveExpense(Expense expense){
        expenseDB.add(expense);
    }

    public static void updateExpense(Expense expense){
        Expense ex = findExpense(expense.getId());
        int index = expenseDB.indexOf(ex);
        expenseDB.add(index,expense);
    }

    public static void deleteExpense(String id){
        Expense expense = findExpense(id);
        expenseDB.remove(expense);
    }

    public static Expense findExpense(String id){
        for(Expense expense : findAllExpenses()){
            if(expense.getId().equals(id)){
                return expense;
            }
        }
        return null;
    }

    public static List<Expense> findExpenses(String query){
        List<Expense> result = new ArrayList<>();
        for(Expense expense : findAllExpenses()){
            if(expense.getId().contains(query) || expense.getExpense().contains(query) || expense.getUserNic().contains(query) || expense.getMethod().contains(query)){
                result.add(expense);
            }
        }
        return result;
    }

    public static List<Expense> findAllExpenses(){
        return expenseDB;
    }


}
