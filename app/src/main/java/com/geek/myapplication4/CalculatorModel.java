package com.geek.myapplication4;


    public class CalculatorModel{
        private int firstArg;
        private int secondArg;

        private StringBuilder inputStr = new StringBuilder();

        private int actionSelected;

        private State state;

        private enum State {
            firstArgInput,
            operationSelected,
            secondArgInput,
            resultShow
        }

        public CalculatorModel() {
            state = State.firstArgInput;
        }

        public void onNumPressed(int buttonId) {

            if (state == State.resultShow) {
                state = State.firstArgInput;
                inputStr.setLength(0);
            }

            if (state == State.operationSelected) {
                state = State.secondArgInput;
                inputStr.setLength(0);
            }

            if (inputStr.length() < 9) {
                switch (buttonId) {
                    case R.id.ac0:
                        if (inputStr.length() != 0) {
                            inputStr.append("0");
                        }
                        break;
                    case R.id.ac1:
                        inputStr.append("1");
                        break;
                    case R.id.ac2:
                        inputStr.append("2");
                        break;
                    case R.id.ac3:
                        inputStr.append("3");
                        break;
                    case R.id.ac4:
                        inputStr.append("4");
                        break;
                    case R.id.ac5:
                        inputStr.append("5");
                        break;
                    case R.id.ac6:
                        inputStr.append("6");
                        break;
                    case R.id.ac7:
                        inputStr.append("7");
                        break;
                    case R.id.ac8:
                        inputStr.append("8");
                        break;
                    case R.id.ac9:
                        inputStr.append("9");
                        break;
                }
            }

        }

        public void onActionPressed(int actionId) {
            if (actionId == R.id.equals && state == State.secondArgInput && inputStr.length() > 0) {
                secondArg = Integer.parseInt(inputStr.toString());
                state = State.resultShow;
                inputStr.setLength(0);
                switch (actionSelected) {
                    case R.id.plus:
                        inputStr.append(firstArg + secondArg);
                        break;
                    case R.id.minus:
                        inputStr.append(firstArg - secondArg);
                        break;
                    case R.id.multiply:
                        inputStr.append(firstArg * secondArg);
                        break;
                    case R.id.division:
                        inputStr.append(firstArg / secondArg);
                        break;
                }

            } else if (inputStr.length() > 0 && state == State.firstArgInput) {
                firstArg = Integer.parseInt(inputStr.toString());
                state = State.operationSelected;
                actionSelected = actionId;
            }
        }

        public String getText () {
            StringBuilder str = new StringBuilder();
            switch (state) {
                default:
                    return inputStr.toString();
                case operationSelected:
                    return str.append(firstArg).append(' ')
                            .append(getOperationChar())
                            .toString();
                case secondArgInput:
                    return str.append(firstArg).append(' ')
                            .append(getOperationChar())
                            .append(' ')
                            .append(inputStr)
                            .toString();
                case resultShow:
                    return str.append(firstArg).append(' ')
                            .append(getOperationChar())
                            .append(' ')
                            .append(secondArg)
                            .append(" = ")
                            .append(inputStr.toString())
                            .toString();
            }
        }

        private char getOperationChar() {
            switch (actionSelected) {
                case R.id.plus:
                    return '+';
                case R.id.minus:
                    return '-';
                case R.id.multiply:
                    return '*';
                case R.id.division:
                default:
                    return '/';

            }
        }

        public void reset() {
            state = State.firstArgInput;
            inputStr.setLength(0);
        }
    }

        /*
        private int firstArg;
        private int secondArg;

        StringBuilder inputSrc = new StringBuilder();

        private State state;

        private enum State {
            firstArgInput,
            secondArgInput,
            resultShow
        }
        public CalculatorModel(){
            state = State.firstArgInput;
        }

        public void onNumPressed(int buttonId){

        }
        public void onActionPressed(int actionId){

        }*/



