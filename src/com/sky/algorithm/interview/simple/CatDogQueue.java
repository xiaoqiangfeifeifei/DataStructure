package com.sky.algorithm.interview.simple;


import com.sky.datastructure.linkedlist.LinkedListQueue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 实现一种狗猫队列的结构，要求如下： 用户可以调用add方法将cat类或dog类的 实例放入队列中；
 * 用户可以调用pollAll方法，将队列中所有的实例按照进队列 的先后顺序依次弹出；
 * 用户可以调用pollDog方法，将队列中dog类的实例按照 进队列的先后顺序依次弹出；
 * 用户可以调用pollCat方法，将队列中cat类的实 例按照进队列的先后顺序依次弹出；
 * 用户可以调用isEmpty方法，检查队列中是 否还有dog或cat的实例；
 * 用户可以调用isDogEmpty方法，检查队列中是否有dog 类的实例；
 * 用户可以调用isCatEmpty方法，检查队列中是否有cat类的实例。
 *
 * @ClassName: CatDogQueue
 * @Author Administrator
 * @Date 2020/5/4
 * @Version 1.0
 */
public class CatDogQueue {

    public static class Pet {
        private String type;

        public Pet(String type) {
            this.type = type;
        }

        public String getPetType() {
            return this.type;
        }
    }

    public static class Dog extends Pet {
        public Dog() {
            super("dog");
        }
    }

    public static class Cat extends Pet {
        public Cat() {
            super("cat");
        }
    }

    public class PetEnter {
        private Pet pet;
        private long count;

        public PetEnter(Pet pet, long count) {
            this.pet = pet;
            this.count = count;
        }

        public Pet getPet() {
            return pet;
        }


        public long getCount() {
            return count;
        }

        public String getEnterPetType() {
            return this.pet.getPetType();
        }
    }


    private Queue<PetEnter> dogQ;
    private Queue<PetEnter> catQ;
    private long count;

    public CatDogQueue() {
        this.dogQ = new LinkedList<>();
        this.catQ = new LinkedList<>();
        this.count = 0;
    }

    public void add(Pet pet) {
        if (pet.getPetType().equals("cat")) {
            catQ.add(new PetEnter(pet, this.count++));

        } else if (pet.getPetType().equals("dog")) {
            dogQ.add(new PetEnter(pet, this.count++));
        } else {
            throw new RuntimeException("err, not dog or cat");
        }
    }

    public Pet pollAll() {
        if (!this.dogQ.isEmpty() && !this.catQ.isEmpty()) {
            if (this.dogQ.peek().getCount() < this.catQ.peek().getCount()) {
                return this.dogQ.poll().getPet();
            } else {
                return this.catQ.poll().getPet();
            }
        } else if (!this.dogQ.isEmpty()) {
            return this.dogQ.poll().getPet();
        } else if (!this.catQ.isEmpty()) {
            return this.catQ.poll().getPet();
        } else {
            throw new RuntimeException("err, queue is empty!");
        }
    }

    public Dog pollDog() {
        if (!this.isDogQueueEmpty()) {
            return (Dog) this.dogQ.poll().getPet();
        } else {
            throw new RuntimeException("Dog queue is empty!");
        }
    }

    public Cat pollCat() {
        if (!this.isCatQueueEmpty()) {
            return (Cat) this.catQ.poll().getPet();
        } else
            throw new RuntimeException("Cat queue is empty!");
    }

    public boolean isEmpty() {
        return this.dogQ.isEmpty() && this.catQ.isEmpty();
    }

    public boolean isDogQueueEmpty() {
        return this.dogQ.isEmpty();
    }

    public boolean isCatQueueEmpty() {
        return this.catQ.isEmpty();
    }

}
