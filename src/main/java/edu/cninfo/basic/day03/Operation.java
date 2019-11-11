package edu.cninfo.basic.day03;

/**
 * @author chenxinwei
 * @date 2019/11/11 17:13
 **/
public enum Operation {

    ADD {
        @Override
        public int eval(int first, int second) {
            return first + second;
        }
    },
    SUBTRACE {
        @Override
        public int eval(int first, int second) {
            return first - second;
        }
    },
    MULTIPLY {
        @Override
        public int eval(int first, int second) {
            return first * second;
        }
    },
    DIVIDE {
        @Override
        public int eval(int first, int second) {
            return first * second;
        }
    };


    public abstract int eval(int first, int second);

}

