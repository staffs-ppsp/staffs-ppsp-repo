<?php
	for ($l='A'; $l<='J'; $l++) {
?>
														<tr>
<?php
		for ($n=1; $n<=16; $n++) {
			$boolUsed = (mt_rand(0,1) == 1);
			$strStyle = ($boolUsed?"seat-used":"seat-unused")." ".($l<='H'?"seat-normal":"seat-premium");
?>
															<td class="seat <?php echo $strStyle; ?>" name="seat" id="seat-<?php echo $l.($n<10?'0':'').$n; ?>">&nbsp;</td>	
<?php
			if ($n == 8) {
?>
															<td class="seat seat-desc-letter"><?php echo $l; ?></td>
<?php
			}
		}
?>
														</tr>
<?php
	}
?>
