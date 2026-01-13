package faraday.molar

import faraday.core.Time

operator fun Catalysis.times(time: Time) = ChemicalAmount(moles = katals * time.seconds)
operator fun Time.times(catalysis: Catalysis): ChemicalAmount = catalysis * this
operator fun ChemicalAmount.div(time: Time) = Catalysis(katals = moles / time.seconds)
operator fun ChemicalAmount.div(catalysis: Catalysis) = Time(seconds = moles / catalysis.katals)
