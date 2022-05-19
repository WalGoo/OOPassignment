import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
/*        Taxi taxi1 = new Taxi();
        taxi1.passengerTakeIn(3);
        taxi1.getDestination("집", 2);
        taxi1.changeSpeed(20);
        taxi1.calLastCharge();
        System.out.println("----------------------------");
        taxi1.passengerTakeIn(2);
        taxi1.getDestination("천호역", 4);
        taxi1.changeSpeed(130);
        taxi1.calLastCharge();*/

        Bus bus = new Bus();
        bus.passengerTakeIn(15);
        bus.passengerTakeIn(14);
    }
}

class Transport {
    int num;
    int oil;
    int nowSpeed;
    int changedSpeed;
    int maxPassenger;
    int nowPassenger;
    boolean isWork;

    public Transport() {
        this.num = (int) (Math.random() * 100);
        this.oil = 100;
        this.nowSpeed = 0;
        this.changedSpeed = 0;
        this.isWork = true;
    }

    public boolean oilCheck() {
        if (this.oil >= 10) {
            return true;
        } else {
            System.out.println("연료가 부족합니다. 현재 연료량 : " + this.oil);
            return false;
        }
    }

    public void changeSpeed(int wantSpeed) {
        if (oilCheck()) {
            if (checkWork()) {
                this.nowSpeed += wantSpeed;
                if (this.nowSpeed > 0) {
                    System.out.println("속도가 변경되었습니다. 현재 속도는 " + this.nowSpeed + " 입니다.");
                } else {
                    this.nowSpeed -= wantSpeed;
                    System.out.println("잘못된 값이 입력되었습니다.");
                }
            }
        }
    }

    // 승객 탑승

    public void passengerTakeIn(int passengers) {
        if (oilCheck()) {
            if (this.nowPassenger + passengers <= this.maxPassenger) {
                this.nowPassenger = passengers;
                this.isWork = true;
                System.out.println("현재 승객 수 : " + nowPassenger);
            } else {
                this.isWork = false;
                System.out.println("최대 정원 수 : " + maxPassenger);
                System.out.println("정원 초과!");
            }
        }
    }


    // 운행 검사
    public boolean checkWork() {
        return (isWork == true) ? true : false;
    }

    // 상태 변경

    public void isHeWork() {
        if (this.isWork) {
            this.isWork = false;
        } else {
            this.isWork = true;
        }
    }
}


class Bus extends Transport {
    int nowPassenger;
    int charge;
    String whereGo;

    public Bus() {
        this.charge = 1200;
        this.whereGo = "운행 중";
        this.maxPassenger = 30;
        this.oil = 100;
        System.out.println("버스 번호 :" + this.num);
    }

    public boolean oilCheck() {
        if (this.oil >= 50) {
            return true;
        } else {
            System.out.println("연료가 부족합니다. 현재 연료량 : " + this.oil);
            this.whereGo = "차고지 행";
            return false;
        }
    }

    public void passengerTakeIn(int passengers) {
        if (oilCheck()) {
            if(whereGo.equals("운행 중")) {
                if (this.nowPassenger + passengers <= this.maxPassenger) {
                    this.nowPassenger = passengers;
                    this.isWork = true;
                    System.out.println("현재 승객 수 : " + nowPassenger);
                    System.out.println("현재 요금 : " + nowPassenger * this.charge);
                    this.oil -= 55;
                    System.out.println("현재 연료량 : " + this.oil);
                } else {
                    this.isWork = false;
                    System.out.println("최대 정원 수 : " + maxPassenger);
                    System.out.println("정원 초과!");
                }
            } else {
                System.out.println("현재 운행 중이 아님.");
            }
        }
    }


}

class Taxi extends Transport {
    int nowPassenger;
    int charge;
    int chargePlusPerDegree;
    String destination;
    int degreeToDestination;
    int degreeBase;

    public Taxi() {
        this.nowPassenger = 0;
        this.charge = 1200;
        this.maxPassenger = 5;
        this.oil = 100;
        System.out.println("택시 번호 : " + num);
    }


    public void getDestination(String destination, int degreeToDestination) {
        if (oilCheck()) {
            if (checkWork()) {
                if (!destination.equals("") && degreeToDestination > 0) {
                    this.destination = destination;
                    this.degreeToDestination = degreeToDestination;
                    System.out.println("목적지 : " + destination);
                    System.out.println("목적지까지의 거리 : " + degreeToDestination);
                } else {
                    System.out.println("잘못된 값을 입력하였습니다.");
                }
            }
        }
    }

    public void calLastCharge() {
        if (oilCheck()) {
            if (checkWork()) {
                this.charge += this.chargePlusPerDegree * (degreeToDestination - this.degreeBase);
                this.oil -= 20;
                this.nowPassenger -= this.nowPassenger;
                nowPassenger -= nowPassenger;
                this.isWork = false;
                System.out.println("현재 연료량 :" + oil);
                System.out.println("최종 요금 : " + this.charge);
            }
        }
    }


}