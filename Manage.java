package ProjectOne;

import java.util.Scanner;

public class Manage {
    private static Scanner sc = new Scanner(System.in);
    private static User[] userArray = new User[10];
    private static int userIndex = 0;
    private static User currentUser;
    private static Hero[] heroArray = new Hero[10];
    private static int heroIndex = 0;


    public static void main(String[] args) {
//        死循环 一级菜单
        while (true) {
            System.out.println("请输入数字进入相应功能:");
            System.out.println("1. 注册  2. 登录  3. 查看所有用户  4. 查看所有英雄  5. 退出系统");
            int input = sc.nextInt();

            if (input == 1) {
//              注册
                resign();
                userIndex++;

            } else if (input == 2) {
                login();

            } else if (input == 3) {
//              查看所有用户
                checkAllUser();

            } else if (input == 4) {
//              查看所有英雄
                checkAllHero();

            } else if (input == 5) {
//                退出登录
                break;

            } else {
                System.out.println("输入数字有误，请重新输入");

            }

        }
    }

    public static void resign() {
        User userAccount = new User();
        userArray[userIndex] = userAccount;

        System.out.print("请输入注册账号:");
        userAccount.setAccount(sc.next());
        System.out.print("请输入注册密码:");
        userAccount.setPwd(sc.next());
        userAccount.setId(userIndex);

    }

    public static void login() {
        System.out.print("请输入账号:");
        String loginAccount = sc.next();
        System.out.print("请输入密码:");
        String loginPwd = sc.next();

//        默认用户登录为失败
        boolean flag = false;

//        循环判断用户输入的账号密码是否有与已有账号密码相匹配的
        for (User user:userArray) {
//            防止空数组被遍历到判断出空指针异常
            if (user == null) {
                continue;

            }
//            判断输入用户名与注册用户是否匹配
            if (user.getAccount().equals(loginAccount) && user.getPwd().equals(loginPwd)) {
                System.out.println("登陆成功");
//                将默认登录失败切换为登陆成功状态
                flag = true;
//                保存当前登录用户信息
                currentUser = user;
                break;

            }
        }

        if (flag == true) {
//            登陆成功 进入二级菜单
            loginSuccess();

        } else {
            System.out.print("输入账号与密码不匹配 请重试");

        }


    }

    public static void checkAllUser() {
        for (User users:userArray) {
            if (users != null) {
                System.out.println(users);
            }
        }
    }


    public static void loginSuccess() {
        while (true) {
            System.out.println("请输入数字进入相应功能");
            System.out.println("1. 新增英雄  2. 查看我的英雄  3. 编辑英雄  4. 删除英雄  5. 退出登录");
            int input = sc.nextInt();
            if (input == 1){
//              新增英雄
                addHero();
                heroIndex++;

            } else if(input == 2) {
//              查看我的英雄
                checkAllHero();

            } else if(input == 3) {
//              编辑英雄
                editHero();
            } else if(input == 4) {
//               删除英雄
                delHero();

            } else if(input == 5) {
//                退出登录
                break;

            } else {
                System.out.println("输入数字有误，请重新输入");

            }

        }
    }

    public static void addHero() {
        Hero hero = new Hero();
        heroArray[heroIndex] = hero;

        hero.setUserID(currentUser.getId());
        System.out.println("请输入要增加的英雄:");
        hero.setName(sc.next());
        System.out.println("请输入英雄职业:");
        hero.setCareer(sc.next());
        System.out.println("请输入英雄技能");
        hero.setSkill(sc.next());
        System.out.println("请输入英雄简介");
        hero.setIntro(sc.next());
//        创作该英雄的用户的编号
        hero.setId(heroIndex);

    }

    public static void checkAllHero() {
        for (Hero hero:heroArray) {

            if (hero == null) {
                continue;
            }

            if (hero.getUserID() == currentUser.getId()) {
                System.out.println(hero);

            }

        }
    }

    public static void editHero() {
        System.out.println("请输入英雄名称: ");
        String name = sc.next();
        for (int i = 0; i < heroArray.length; i++) {

            if (heroArray[i] == null) {
                continue;
            }

            if (name.equals(heroArray[i].getName())) {
                System.out.println(heroArray[i]);
                System.out.println("如需要修改英雄名称，请修改;如不需要请按1 ");
                String input = sc.next();
                if (input.equals("1")) {

                } else {
                    heroArray[i].setName(input);
                }

                System.out.println("如需要修改英雄职业，请修改；如不需要请按1 ");
                String input2 = sc.next();
                if (input2.equals("1")) {

                } else {
                    heroArray[i].setCareer(input2);
                }

                System.out.println("如需要修改英雄介绍，请修改；如不需要请按1 ");
                String input3 = sc.next();
                if (input3.equals("1")) {

                } else {
                    heroArray[i].setIntro(input3);
                }

                System.out.println("如需要修改英雄技能，请修改；如不需要请按1 ");
                String input4 = sc.next();
                if (input4.equals("1")) {

                } else {
                    heroArray[i].setIntro(input4);
                }


            }

        }
    }

    public static void delHero() {
        System.out.println("请输入要删除的英雄名称: ");
        String name = sc.next();
        int t = 0;
        for (int i = 0; i < heroArray.length; i++) {
            if (heroArray[i] == null) {
                continue;

            }
            if (name.equals(heroArray[i].getName()) && heroArray[i].getUserID() == currentUser.getId()) {
                heroArray[i] = null;
                t = 1;
                break;
            } else if (heroArray[i].getUserID() != currentUser.getId()) {
                t = 2;
            } else if (!name.equals(heroArray[i].getName())) {
                t = 3;
            }

        }

        if (t == 1 ){
            System.out.println("删除成功");

        } else if (t == 2) {
            System.out.println("该英雄不存在或该英雄不是此用户所创造，无权限修改");

        } else if (t == 3) {
            System.out.println("该英雄不存在");

        }

    }

}
