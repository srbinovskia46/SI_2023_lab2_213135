# Андреј Србиновски 213135

# **Control Flow Graph**

![SILab2_Final drawio](https://github.com/srbinovskia46/SI_2023_lab2_213135/assets/108271909/a5eccf1e-dbbe-449a-988e-be950d87f916)


# **Цикломатска комплексност**

Цикломатската комплексност на овој код е 11, тоа го добив од формулата P+1, каде P е број на предикатни јазли. P = 10 + 1, значи цикломатската комплексност е 11. Истото го потврдив со бројот на региони. R=број на региони. Бројот на региони за овој код е 11. R=11.

# **Тест случаи според критериумот Every branch**

**1. user.password == null**
- Атрибутот password во објектот User го поставуваме на null и со тоа програмата фрла исклучок и се завршува.

**2. user.username == null, user.password == pass, валидна емаил адреса, во users нема корисник со исти податоци**
- Доколку атрибутите username, email и password на објектот User ги поставиме на username=null, password == "pass" и email="test@test.com", тогаш програмата ќе се изврши и ќе врати false.

**3. user.username == user, user.password=password46#, не валидна емаил адреса, во users нема корисник со исти податоци**
- Доколку атрибутите user, password и email на објектот User ги поставиме на user="user", password="password46#" и email="email", и во users нема корисник со исти податоци, програмата ќе врати false, бидејќи е внесена невалидна емаил адреса.

**4. user.username == user, user.password=password 46, валидна емаил адреса, во users има веќе корисник со исти податоци**
- Доколку атрибутите user, password и email на објектот User ги поставиме на user="user", password="password 46" и email="email@test.com", при проверка на валидност на password ќе се врати false и потоа функцијата враќа false и со тоа се завршува програмата.

**5. user.username == user, user.password=password46, валидна емаил адреса, во users нема корисник со исти податоци**
- Доколку атрибутите user, password и email на објектот User ги поставиме на user="user", password="password46" и email="email@test.com", при проверка на password нема да гиде исполнет условот за дали содржи специјални карактери и со тоа функцијата враќа false.


# **Тест случаи според критериумот Multiple condition**

 Со овие тестови го тестираме следниот услов _**if (user==null || user.getPassword()==null || user.getEmail()==null)**_
 
 Ги имамe следните можни исходи:
 
**1. T || X || X**

- Доколку првиот услов е точен(user==null), тогаш целиот израз е точен.
 
**2. F || T || X**

- Доколку првиот услов не е точен(user!=null), а вториот е точен(user.getPassword()==null), тогаш целиот израз е точен.

**3. F || F || T**

- Доколку само третиот услов е испонет(user.getEmail()==null), а првите два не се, тогаш целиот изразот е точен.

**4. F || F || F**

- Доколку сите услови се неточни, тогаш целиот исказ е неточен.

