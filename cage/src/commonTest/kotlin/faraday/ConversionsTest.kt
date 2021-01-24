package faraday

import faraday.base.meters
import faraday.base.seconds
import faraday.derived.*
import faraday.derived.mechanical.cubicMeters
import kotlin.test.Test

internal class ConversionsTest : BaseTest {
    @Test
    fun energyConversions() {
        1.joules shouldBeEqualTo (1.newtons * 1.meters)
        1.joules shouldBeEqualTo (1.meters * 1.newtons)
        1.meters shouldBeEqualTo (1.joules / 1.newtons)
        1.newtons shouldBeEqualTo (1.joules / 1.meters)

        1.joules shouldBeEqualTo (1.pascals * 1.cubicMeters)
        1.joules shouldBeEqualTo (1.cubicMeters * 1.pascals)
        1.pascals shouldBeEqualTo (1.joules / 1.cubicMeters)
        1.cubicMeters shouldBeEqualTo (1.joules / 1.pascals)

        1.joules shouldBeEqualTo (1.watts * 1.seconds)
        1.joules shouldBeEqualTo (1.seconds * 1.watts)
        1.watts shouldBeEqualTo (1.joules / 1.seconds)
        1.seconds shouldBeEqualTo (1.joules / 1.watts)

        1.joules shouldBeEqualTo (1.coulombs * 1.volts)
        1.joules shouldBeEqualTo (1.volts * 1.coulombs)
        1.coulombs shouldBeEqualTo (1.joules / 1.volts)
        1.volts shouldBeEqualTo (1.joules / 1.coulombs)
    }
}
