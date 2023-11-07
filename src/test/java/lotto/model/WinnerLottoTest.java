package lotto.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinnerLottoTest {
    @DisplayName("로또와 당첨로또를 비교하여 등수를 반환한다(1등).")
    @Test
    void calculateRankFirst() {

        WinnerLotto winnerLotto = new WinnerLotto(new Lotto(List.of(1,2,3,4,5,6)),7);

        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));

        Rank rank = winnerLotto.compare(lotto);

        assertThat(rank).isEqualTo(Rank.FIRST);
    }
    @DisplayName("로또와 당첨로또를 비교하여 등수를 반환한다(2등).")
    @Test
    void calculateRankSecond() {

        WinnerLotto winnerLotto = new WinnerLotto(new Lotto(List.of(1,2,3,4,5,6)),7);

        Lotto lotto = new Lotto(List.of(1,2,3,4,5,7));

        Rank rank = winnerLotto.compare(lotto);

        assertThat(rank).isEqualTo(Rank.SECOND);
    }
    @DisplayName("로또와 당첨로또를 비교하여 등수를 반환한다(3등).")
    @Test
    void calculateRankThird() {

        WinnerLotto winnerLotto = new WinnerLotto(new Lotto(List.of(1,2,3,4,5,6)),7);

        Lotto lotto = new Lotto(List.of(1,2,3,4,5,8));

        Rank rank = winnerLotto.compare(lotto);

        assertThat(rank).isEqualTo(Rank.THIRD);
    }
    @DisplayName("로또와 당첨로또를 비교하여 등수를 반환한다(4등).")
    @Test
    void calculateRankForth() {

        WinnerLotto winnerLotto = new WinnerLotto(new Lotto(List.of(1,2,3,4,5,6)),7);

        Lotto lotto = new Lotto(List.of(1,2,3,4,8,9));

        Rank rank = winnerLotto.compare(lotto);

        assertThat(rank).isEqualTo(Rank.FOURTH);
    }
    @DisplayName("로또와 당첨로또를 비교하여 등수를 반환한다(5등).")
    @Test
    void calculateRankFifth() {

        WinnerLotto winnerLotto = new WinnerLotto(new Lotto(List.of(1,2,3,4,5,6)),7);

        Lotto lotto = new Lotto(List.of(1,2,3,8,9,10));

        Rank rank = winnerLotto.compare(lotto);

        assertThat(rank).isEqualTo(Rank.FIFTH);
    }

    @DisplayName("로또와 당첨로또를 비교하여 등수를 반환한다(등수없음).")
    @Test
    void calculateRankNone() {

        WinnerLotto winnerLotto = new WinnerLotto(new Lotto(List.of(1,2,3,4,5,6)),7);

        Lotto lotto = new Lotto(List.of(11,12,13,14,15,16));

        Rank rank = winnerLotto.compare(lotto);

        assertThat(rank).isEqualTo(Rank.NONE);
    }


}