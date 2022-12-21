//package com.crystal.atm.dao;
//
//import com.crystal.atm.model.Account;
//import com.crystal.atm.model.Card;
//import com.crystal.atm.model.User;
//import org.apache.commons.csv.CSVFormat;
//import org.apache.commons.csv.CSVParser;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.nio.charset.StandardCharsets;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Objects;
//import java.util.stream.Collectors;
//
//public class DataFromFile implements  DataAccess{
//    //    public void setUsers(List<User> users) throws IOException {
////        this.users = users;
////        getUsersBasicInfo().forEach(user -> {
////            try {
////                users.add(new User(user.getId()
////                        , user.getFirstName()
////                        , user.getLastName()
////                        , user.getAge()
////                        , getAccountsBasicInfo().stream().filter(acc -> Objects.equals(acc.getUserId(), user.getId())).collect(Collectors.toList())));
////            } catch (IOException e) {
////                throw new RuntimeException(e);
////            }
////        });
////    }
//    public DataFromFile() throws IOException {
//        setUsers();
//    }
//    private final List<User> users = new ArrayList<>();
//    private final List<Account> accounts = new ArrayList<>();
//    private final List<Card> allCards = new ArrayList<>();
//    private final CSVFormat format = CSVFormat.Builder.create(CSVFormat.DEFAULT)
//            .setHeader()
//            .setSkipHeaderRecord(true)
//            .build();
//
//
//    @Override
//    public void setUsers() throws IOException {
//        getUsers();
//    }
//
//    public List<User> getUsersBasicInfo() throws IOException {
//        InputStream usersfile = test.class.getResourceAsStream("/userList.csv");
//        assert usersfile != null;
//        try (CSVParser csvParser = new CSVParser(new InputStreamReader(usersfile, StandardCharsets.UTF_8), format)) {
//            return csvParser.stream()
//                    .map(csvRecord -> User.builder()
//                            .id(csvRecord.get(0))
//                            .firstName(csvRecord.get(1))
//                            .lastName(csvRecord.get(2))
//                            .age(Integer.parseInt(csvRecord.get(3)))
//                            .build())
//                    .collect(Collectors.toList());
//        }
//
//    }
//
//    public List<Account> getAccountsBasicInfo() throws IOException {
//        InputStream accountsfile = test.class.getResourceAsStream("/accountList.csv");
//
//        assert accountsfile != null;
//        try (CSVParser csvParser = new CSVParser(new InputStreamReader(accountsfile, StandardCharsets.UTF_8), format)) {
//            return csvParser.stream()
//                    .map(csvRecord -> Account.builder()
//
//                            .userId(csvRecord.get(0))
//                            .accNumber(csvRecord.get(1))
//                            .iban(csvRecord.get(2))
//                            .balance((long) Double.parseDouble((csvRecord.get(3))))
//                            .build())
//                    .collect(Collectors.toList());
//        }
//    }
//
//    public List<Card> getCardsBasicInfo() throws IOException {
//        InputStream cardsfile = DataFromFile.class.getResourceAsStream("/cardList1.csv");
//        assert cardsfile != null;
//        try (CSVParser csvParser = new CSVParser(new InputStreamReader(cardsfile, StandardCharsets.UTF_8), format)) {
//            return csvParser.stream()
//                    .map(csvRecord -> Card.builder()
//                            .idCard(csvRecord.get(0))
//                            .AccountId(csvRecord.get(1))
//                            .pin(csvRecord.get(2))
//                            .cvv(csvRecord.get(3))
//                            .validMonth(Integer.parseInt(csvRecord.get(4)))
//                            .validYear(Integer.parseInt(csvRecord.get(5)))
//                            .build())
//                    .collect(Collectors.toList());
//        }
//    }
//
//    public List<Account> getAccounts() throws IOException {
//        getAccountsBasicInfo().forEach(account -> {
//                    try {
//                        accounts.add(new Account(account.getUserId(), account.getAccNumber(), account.getIban(), account.getBalance(), getCardsBasicInfo().stream().filter(card -> Objects.equals(card.getAccountId(), account.getAccNumber())).collect(Collectors.toList())));
//                    } catch (IOException e) {
//                        throw new RuntimeException(e);
//                    }
//                }
//        );
//        return accounts;
//    }
//
//    @Override
//    public List<User> getUsers() throws IOException {
//        getUsersBasicInfo().forEach(user -> {
//            try {
//                users.add(new User(user.getId(), user.getFirstName(), user.getLastName(),
//                        user.getAge(), getAccounts().stream().filter(account -> Objects.equals(account.getUserId(), user.getId())).collect(Collectors.toList())));
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        });
//        return users;
//    }
//
//    @Override
//    public void setUser(User user) throws IOException {
//        users.add(user);
//    }
//}
