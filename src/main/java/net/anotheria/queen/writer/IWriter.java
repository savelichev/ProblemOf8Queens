package net.anotheria.queen.writer;


/**
 * Write PositionFinder result.
 */
public interface IWriter {


    /**
     * Write positions into source of relevant realization.
     *
     * @param positions queens combinations.
     */
    void write(int[] positions);
}
