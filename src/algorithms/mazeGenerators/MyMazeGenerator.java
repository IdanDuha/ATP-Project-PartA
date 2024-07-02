package algorithms.mazeGenerators;
import java.security.spec.ECField;
import java.util.*;
import java.util.List;

public class MyMazeGenerator extends AMazeGenerator {
    List<Position> validNeighbor = new ArrayList<Position>(); //the valid cells neighbor of spacific cell
    Map<String, Integer> cellVisitedMap = new HashMap<String, Integer>(); // the visited cells map

    @Override
    public Maze generate(int rows, int columns) {
        try {
            if (rows < 2 || columns < 2) {
                throw new IllegalArgumentException("Maze must have rows or columns larger that 1");
            }

            Position StartPoint = setPointonEdge(rows, columns);
            Position GoalPoint;
            do {
                GoalPoint = setPointonEdge(rows, columns);

            } while (StartPoint.equals(GoalPoint));


            Maze m = new Maze(rows, columns, StartPoint, GoalPoint);
            setAllWall(m);
            Random r = new Random();

            cellVisitedMap.replace(StartPoint.toString(), 1);
            updateValidNeighbor(StartPoint, m);


            while (!validNeighbor.isEmpty()) {
                int index = r.nextInt(validNeighbor.size());
                Position visitN = validNeighbor.remove(index);
                cellVisitedMap.replace(visitN.toString(), 1);
                if (countVisitedNeighbor(visitN, m) == 1) {
                    boolean isFrame = visitN.getRowIndex() == 0 || visitN.getColIndex() == 0 || visitN.getRowIndex() == m.getRow() - 1 || visitN.getColIndex() == m.getCol() - 1;
                    boolean notstart = visitN.getRowIndex() != m.getStartPosition().getRowIndex() || visitN.getColIndex() != m.getStartPosition().getColIndex();
                    if (isFrame && notstart) {
                        m.getMaze()[visitN.getRowIndex()][visitN.getColIndex()] = 0;
                        updateValidNeighbor(visitN, m);
                        m.setGoalPoint(visitN);
                    } else {
                        m.getMaze()[visitN.getRowIndex()][visitN.getColIndex()] = 0;
                        updateValidNeighbor(visitN, m);
                        validNeighbor.remove(visitN);
                    }
                }
            }
            if (m.getGoalPosition() == null)
                checkNullGoalPos(m);
            return m;
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }


    public void setAllWall(Maze m) {
        for (int i = 0; i < m.getRow(); i++) {
            for (int j = 0; j < m.getCol(); j++) {
                Position p = new Position(i, j);
                cellVisitedMap.put(p.toString(), 0);
                m.getMaze()[i][j] = 1;
            }
        }
    }

    public void checkNullGoalPos(Maze m) {
        if (m.getGoalPosition() == null) {
            List<Position> neighbors = new ArrayList<Position>();
            if (m.getStartPosition().getRowIndex() + 1 < m.getRow())
                neighbors.add(new Position(m.getStartPosition().getRowIndex() + 1, m.getStartPosition().getColIndex()));
            if (m.getStartPosition().getRowIndex() - 1 >= 0)
                neighbors.add(new Position(m.getStartPosition().getRowIndex() - 1, m.getStartPosition().getColIndex()));
            if (m.getStartPosition().getColIndex() + 1 < m.getCol())
                neighbors.add(new Position(m.getStartPosition().getRowIndex(), m.getStartPosition().getColIndex() + 1));
            if (m.getStartPosition().getColIndex() - 1 >= 0)
                neighbors.add(new Position(m.getStartPosition().getRowIndex(), m.getStartPosition().getColIndex() - 1));
            Collections.shuffle(neighbors);
            Position Pos = neighbors.get(0);
            m.getMaze()[Pos.getRowIndex()][Pos.getColIndex()] = 0;
            m.setGoalPoint(Pos);
        }
    }

    public void updateValidNeighbor(Position p, Maze m) {
        Position temp;
        int x = p.getColIndex() - 1;
        if (p.getColIndex() - 1 == -1)
            x = 1;
        for (int i = x; i <= p.getColIndex() + 2 && i >= 0 && i <= m.getCol() - 1; i += 2) {
            temp = new Position(p.getRowIndex(), i);
            if (cellVisitedMap.get(temp.toString()) == 0)
                validNeighbor.add(temp);

        }

        //check cell rows neighbords and add the neighbords that not visited
        x = p.getRowIndex() - 1;
        if (p.getRowIndex() - 1 == -1)
            x = 1;
        for (int i = x; i < p.getRowIndex() + 2 && i >= 0 && i <= m.getRow() - 1; i += 2) {
            temp = new Position(i, p.getColIndex());
            if (cellVisitedMap.get(temp.toString()) == 0)
                validNeighbor.add(temp);
        }
    }

    public int countVisitedNeighbor(Position p, Maze m) {
        Position temp;
        int c = 0;
        int x = p.getColIndex() - 1;
        if (p.getColIndex() - 1 == -1)
            x = 1;
        for (int i = x; i < p.getColIndex() + 2 && i >= 0 && i <= m.getCol() - 1; i += 2) {
            temp = new Position(p.getRowIndex(), i);
            if (cellVisitedMap.get(temp.toString()) == 1)
                c++;
        }
        x = p.getRowIndex() - 1;
        if (p.getRowIndex() - 1 == -1)
            x = 1;
        for (int i = x; i < p.getRowIndex() + 2 && i >= 0 && i <= m.getRow() - 1; i += 2) {
            temp = new Position(i, p.getColIndex());
            if (cellVisitedMap.get(temp.toString()) == 1)
                c++;
        }
        return c;

    }


}